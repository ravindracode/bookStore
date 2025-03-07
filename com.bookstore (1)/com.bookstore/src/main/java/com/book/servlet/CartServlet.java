package com.book.servlet;

import java.io.IOException;

import com.book.DAOimpl.BookDAOimpl;
import com.book.model.Book;
import com.book.model.Cart;
import com.book.model.CartItems;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        String action = request.getParameter("action");
        int bookid = Integer.parseInt(request.getParameter("bookid"));

        BookDAOimpl bookDAOimpl = new BookDAOimpl();
        Book book = bookDAOimpl.getBook(bookid);

        if (book == null) {
            response.sendRedirect("cart.jsp?error=BookNotFound");
            return;
        }

        try {
            if ("add".equals(action)) {
                CartItems cartItem = new CartItems(
                        book.getBookid(),
                        book.getGenresid(),
                        book.getBookname(),
                        book.getPrice(),
                        1 ,// Default quantity is 1
                        book.getImagepath()
                );
                cart.additems(cartItem);
            } else if ("update".equals(action)) {
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                cart.updateItems(bookid, quantity);
            } else if ("remove".equals(action)) {
                cart.removeItems(bookid);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        session.setAttribute("cart", cart);
        response.sendRedirect("cart.jsp");
    }
}
