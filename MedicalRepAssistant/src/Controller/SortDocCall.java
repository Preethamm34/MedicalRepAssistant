package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Dao;
import Model.AddDoctorCalls;

/**
 * Servlet implementation class SortDocCall
 */
@WebServlet("/SortDocCall")
public class SortDocCall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortDocCall() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		String location = request.getParameter("location");
		String doctorcallon = request.getParameter("doctorcallon");
		System.out.println(location + doctorcallon);
		
		List<AddDoctorCalls> addDoctorCalls = Dao.getAddDoctorCalls(location, doctorcallon);
		RequestDispatcher rd = null;
		System.out.println(addDoctorCalls);
		request.setAttribute("doctorDetails", addDoctorCalls);
		rd = request.getRequestDispatcher("SortDoctorCalls.jsp");
		rd.forward(request, response);
	
	
	
	}
}
