package com.book.servlet;

import java.io.IOException;

import com.book.DAO.UserDAO;
import com.book.DAOimpl.UserDAOimpl;
import com.book.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	
	@Override
    public void init() {
        userDAO = new UserDAOimpl();
    }
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("Email");
		String password = request.getParameter("Password");
	
//		if(email.equals("123@gamil.com") && password.equals("123")) {
//			response.sendRedirect("genres");
//		}
		
		User user = userDAO.validateUser(email, password);
		
		
		if(user !=null) {
			HttpSession session = request.getSession();
			session.setAttribute("user" ,user);
			response.sendRedirect("genres");
			
		}
		else {
			request.setAttribute("errorMessage", "Invalid email or password!");
            RequestDispatcher rd = request.getRequestDispatcher("login.html");
            rd.forward(request, response);
		}
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
