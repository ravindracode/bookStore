package com.book.servlet;

import java.io.IOException;
import java.util.List;

import com.book.DAOimpl.GenresDAOimpl;
import com.book.model.Genres;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/genres")
public class GenresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GenresDAOimpl genresDAOimpl = new GenresDAOimpl();
		List<Genres> genres = genresDAOimpl.getAllGenres();
		
		request.setAttribute("g", genres);
		RequestDispatcher rd = request.getRequestDispatcher("genres.jsp");
		rd.forward(request, response);
		
		
	}

}
