package com.book.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.book.DAOimpl.FictionDAOimpl;
import com.book.model.Fiction;

/**
 * Servlet implementation class FictionServlet
 */
@WebServlet("/fiction")
public class FictionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
						FictionDAOimpl fictionDAOimpl = new FictionDAOimpl();
						List<Fiction> allFictions = fictionDAOimpl.getALLFictions();
						
						request.setAttribute("f", allFictions);
						RequestDispatcher rd = request.getRequestDispatcher("fiction.jsp");
						rd.forward(request, response);
	
	
	
	}

	
}
