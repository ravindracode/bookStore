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
import com.book.DAOimpl.GenresDAOimpl;
import com.book.model.Book;
import com.book.model.Genres;


@WebServlet("/book")
public class Bookservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
						int id = Integer.parseInt(request.getParameter("genresid"));
						
						GenresDAOimpl genresDAOimpl = new GenresDAOimpl();
						Genres genres = genresDAOimpl.getGenres(id);
						
						
						BookDAOimpl bookDAOimpl = new BookDAOimpl();
						List<Book> allBooksbyGenres = bookDAOimpl.getAllBooksbyGenres(id);
						
						
						request.setAttribute("genresid", id);
						request.setAttribute("b", allBooksbyGenres);
						request.setAttribute("gr", genres);
						
						
						//for check out page
						request.getSession().setAttribute("genresid", id);
						
						RequestDispatcher rd = request.getRequestDispatcher("book.jsp");
						rd.forward(request, response);
		
		
		
	}

}
