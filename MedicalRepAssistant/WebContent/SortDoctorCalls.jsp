<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sort Details</title>
<style>
table, th, td {
  border:1px solid black;
  border-collapse: collapse;
  width:auto;
}
body{
	background-color: #F0FF42;
	}
button{
width : 50px; 
        overflow: hidden;    
        padding: 10px;  
        background-color: #34465d;  
        border-radius: 20px ;
}	
a{
color: #F0FF42;
}
</style>
</head>
<body>


<%@page import="java.util.ArrayList"%>      <%--Importing all the dependent classes--%>
<%@page import="Model.AddDoctorCalls"%>
<%@page import="java.util.Iterator"%>

<button><a href="AddDoctorCalls.jsp">Back</a></button>
<br><br>

<table>
<tr>
<th>Sl No</th>
<th>Doctor Name</th>
<th>Phone Number</th>
<th>Address</th>
<th>Location</th>
<th>Sample Details</th>
<th>Doctor Call On</th>
</tr>

<% ArrayList<AddDoctorCalls> addDoctorCallsList = (ArrayList) request.getAttribute("doctorDetails");%>
<%
if(request.getAttribute("doctorDetails") != null){
Iterator<AddDoctorCalls> iterator = addDoctorCallsList.iterator();
while(iterator.hasNext()){
	AddDoctorCalls addDoctorCalls = iterator.next();
%>

<tr>
<td><%=addDoctorCalls.getUserId() %></td>
<td><%=addDoctorCalls.getDoctorname() %></td>
<td><%=addDoctorCalls.getPhonenumber() %></td>
<td><%=addDoctorCalls.getAddress() %></td>
<td><%=addDoctorCalls.getLocation() %></td>
<td><%=addDoctorCalls.getSampledetails() %></td>
<td><%=addDoctorCalls.getDoctorcallon() %></td>
</tr>
<%
	}
}
%>
</table>



</body>
</html>