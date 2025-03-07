package com.book.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.book.DAOimpl.BookDAOimpl;
import com.book.model.Book;

@WebServlet("/bestseller")
public class BestsellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				
						BookDAOimpl bookDAOimpl = new BookDAOimpl();
						List<Book> allBooks = bookDAOimpl.getAllBooks();
						
						request.setAttribute("allbooks", allBooks);
						
						RequestDispatcher rd = request.getRequestDispatcher("bestseller.jsp");
						rd.forward(request, response);
		
		
		
		
	}

	

}
