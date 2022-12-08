package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Dao;
import Model.User;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
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
		String emailid = request.getParameter("emailid");
		String phonenumber = request.getParameter("phonenumber");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setEmailid(emailid);
		user.setPhonenumber(phonenumber);
		user.setPassword(password);
		
		System.out.println(user);
		
		Dao dao = new Dao();
		RequestDispatcher rd = null;
		int rowNumber = Dao.registerUser(user);
		
		if(rowNumber > 0) {
			System.out.println("User registration Successfull");
			request.setAttribute("msg", "User registration Successfull please login");
			rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		else {
			System.out.println("Registration Failed Try Again");
			request.setAttribute("msg", "Registration Failed Try Again");
			rd = request.getRequestDispatcher("Signin.jsp");
			rd.forward(request, response);
		}
	}
}
