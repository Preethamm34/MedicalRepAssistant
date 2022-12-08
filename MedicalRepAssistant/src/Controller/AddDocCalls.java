package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Dao;
import Model.AddDoctorCalls;

/**
 * Servlet implementation class AddDocCalls
 */
@WebServlet("/AddDocCalls")
public class AddDocCalls extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDocCalls() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		 String doctorname = request.getParameter("doctorname");
		 String phonenumber = request.getParameter("phonenumber");
		 String address = request.getParameter("address");
		 String location = request.getParameter("location");
		 String sampledetails = request.getParameter("sampledetails");
		 String doctorcallon = request.getParameter("doctorcallon");
		 
		 AddDoctorCalls addDoctorCalls = new AddDoctorCalls();
		 addDoctorCalls.setDoctorname(doctorname);
		 addDoctorCalls.setPhonenumber(phonenumber);
		 addDoctorCalls.setAddress(address);
		 addDoctorCalls.setLocation(location);
		 addDoctorCalls.setSampledetails(sampledetails);
		 addDoctorCalls.setDoctorcallon(doctorcallon);
		 
		 System.out.println(addDoctorCalls);
		 
		 Dao dao = new Dao();
		 RequestDispatcher rd = null;
		 int rowNumber = Dao.registerDoctorCalls(addDoctorCalls);

		 if(rowNumber > 0) {
			 request.setAttribute("msg", "Doctor Details Added Successfully");
			 rd = request.getRequestDispatcher("AddDoctorCalls.jsp");
			 rd.forward(request, response);
		 }
		 else {
			 request.setAttribute("msg", "Retry Adding Doctor Details");
			 rd = request.getRequestDispatcher("AddDoctorCalls.jsp");
			 rd.forward(request, response);
		 }
	}

}
