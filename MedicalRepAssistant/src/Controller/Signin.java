package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import DAO.Dao;
import Model.Login;

/**
 * Servlet implementation class Signin
 */
@WebServlet("/Signin")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
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
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);
		
		
		
		Dao dao = new Dao();
		RequestDispatcher rd = null;
		System.out.println(login);
		int rowNumber = Dao.validateUser(login);
		
		if(rowNumber > 0) {
			System.out.println("Login Successful");
			request.setAttribute("msg", "Login successful");
			rd = request.getRequestDispatcher("AddDoctorCalls.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("msg", "Login Failed, Try Again");
			rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		
		
		
		
		
	}

}
