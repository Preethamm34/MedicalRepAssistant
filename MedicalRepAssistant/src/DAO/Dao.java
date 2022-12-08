package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import DataBase.DbConnectorAddDoctorCalls;
import DataBase.DbConnectorRegistration;
import Model.AddDoctorCalls;
import Model.Login;
import Model.User;

public class Dao {

	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static int registerUser(User user) {
		String sql = "insert into User(username, emailid, phonenumber, password) values ('"+user.getUsername()+"','"+user.getEmailid()+"','"+user.getPhonenumber()+"','"+user.getPassword()+"')";
		System.out.println(sql);
		int i = 0;
		
		try {
			conn = DbConnectorRegistration.getConnection();
			ps = conn.prepareStatement(sql);
			i = ps.executeUpdate();
		} 
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			DbConnectorRegistration.closeStatement(ps);
			DbConnectorRegistration.closeConnection(conn);		
		}
	return i;
}
	
public static int validateUser(Login login) {
	
	String sql = "SELECT * FROM user WHERE user.username='"+login.getUsername()+"' AND user.password='"+login.getPassword()+"'";
	System.out.println(sql);
	int i = 0;
	try {
		conn = DbConnectorRegistration.getConnection();
		stmt = (Statement) conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			rs.getString("username");
			rs.getString("password");
		if(rs.getString("username").equals(login.getUsername()) && rs.getString("password").equals(login.getPassword()));	
		return 1;
		}
	return 0;
} catch (SQLException e) {
	System.out.println(e.getMessage());
	e.printStackTrace();
}finally {
	DbConnectorRegistration.closeConnection(conn);
	DbConnectorRegistration.closeStatement(ps);
}

return i;	
}

public static int registerDoctorCalls(AddDoctorCalls addDoctorCalls) {
	
	String sql = "insert into doctorcall (doctorname, phonenumber, address, location, sampledetails, doctorcallon) values ('"+addDoctorCalls.getDoctorname()+"','"+addDoctorCalls.getPhonenumber()+"','"+addDoctorCalls.getAddress()+"','"+addDoctorCalls.getLocation()+"','"+addDoctorCalls.getSampledetails()+"','"+addDoctorCalls.getDoctorcallon()+"')";
	System.out.println(sql);
	int i = 0;
	
	try {
		conn = DbConnectorAddDoctorCalls.getConnection();
		ps = conn.prepareStatement(sql);
		i = ps.executeUpdate();
}
	catch(SQLException e) {
		e.printStackTrace();
	}
	finally {
		DbConnectorAddDoctorCalls.closeConnection(conn);
		DbConnectorAddDoctorCalls.closeStatement(ps);
	}
return i;
}

public static List<AddDoctorCalls> getAddDoctorCalls(){
	
	String sql = "SELECT * FROM doctorcall";
	System.out.println(sql);
	List<AddDoctorCalls> doctorCall = new ArrayList();
	
	try {
		conn = DbConnectorAddDoctorCalls.getConnection();
		stmt = (Statement) conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			AddDoctorCalls addDoctorCalls = new AddDoctorCalls();
			addDoctorCalls.setUserId(rs.getInt("userId"));
			addDoctorCalls.setDoctorname(rs.getString("doctorname"));
			addDoctorCalls.setPhonenumber(rs.getString("phonenumber"));
			addDoctorCalls.setAddress(rs.getString("address"));
			addDoctorCalls.setLocation(rs.getString("location"));
			addDoctorCalls.setSampledetails(rs.getString("sampledetails"));
			addDoctorCalls.setDoctorcallon(rs.getString("doctorcallon"));
			doctorCall.add(addDoctorCalls);
		}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			DbConnectorAddDoctorCalls.closeStatement(ps);
			DbConnectorAddDoctorCalls.closeConnection(conn);
		}
return doctorCall;
}

public static List<AddDoctorCalls> getAddDoctorCalls(String location, String doctorcallon){
	
	String sql = "SELECT * FROM doctorcall WHERE doctorcall.location='"+location+"' AND  doctorcall.doctorcallon='"+doctorcallon+"'";
			System.out.println(sql);
	List<AddDoctorCalls> doctorDetails = new ArrayList();
	
	try {
		conn = DbConnectorAddDoctorCalls.getConnection();
		stmt = (Statement) conn.createStatement();
		rs = stmt.executeQuery(sql);	
		
		while(rs.next()) {
			AddDoctorCalls addDoctorCalls = new AddDoctorCalls();
			addDoctorCalls.setUserId(rs.getInt("userId"));
			addDoctorCalls.setDoctorname(rs.getString("doctorname"));
			addDoctorCalls.setPhonenumber(rs.getString("phonenumber"));
			addDoctorCalls.setAddress(rs.getString("address"));
			addDoctorCalls.setLocation(rs.getString("location"));
			addDoctorCalls.setSampledetails(rs.getString("sampledetails"));
			addDoctorCalls.setDoctorcallon(rs.getString("doctorcallon"));
			doctorDetails.add(addDoctorCalls);
		}
	}catch(SQLException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}finally {
		DbConnectorAddDoctorCalls.closeStatement(ps);
		DbConnectorAddDoctorCalls.closeConnection(conn);
	}
	return doctorDetails;
}
}