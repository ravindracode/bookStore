package com.book.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Map;

import com.book.DAO.OrderitemsDAO;
import com.book.DAO.orderDAO;
import com.book.DAOimpl.OrderDAOimpl;
import com.book.DAOimpl.OrderitemsDAOimpl;
import com.book.model.Cart;
import com.book.model.CartItems;
import com.book.model.Orderitems;
import com.book.model.Orders;
import com.book.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/Checkout")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 	private orderDAO OrderDAO;
	    private OrderitemsDAO orderitemdDAO;
	
		@Override
		public void init() throws ServletException {
			
			try {
				
				OrderDAO = new OrderDAOimpl();
				 orderitemdDAO = new OrderitemsDAOimpl();
			} 
			
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		Cart cart=(Cart)session.getAttribute("cart");
		User user=(User)session.getAttribute("user");
		
		
		if(cart!=null && user != null && !cart.getItems().isEmpty()) {
			String paymentmode=request.getParameter("paymentmode");
			double  totalamount=0;
			
			for(CartItems item:cart.getItems().values()) {
				
				totalamount+=item.getPrice()*item.getQuatity();
			}
			
			
			
			Orders order = new Orders();
			
			order.setUserid(user.getUserid());
			
			Integer genresid =(Integer)session.getAttribute("genresid");
			
			if(genresid==null) {
				System.out.println("ERROR:genresid is null");
				response.sendRedirect("book.jsp");
				return;
			}
			
			order.setGenresid(genresid);
			order.setOrderdate(new Timestamp(System.currentTimeMillis()));
			order.setPaymentmode(paymentmode);
			order.setStatus("Successful");
			order.setTotalamount(totalamount);
			
			
			OrderDAO.addOrder(order);
			
			for (Map.Entry<Integer, CartItems> entry : cart.getItems().entrySet()) {
				
						CartItems cartitems = entry.getValue();
						
						Orderitems orderitems = new Orderitems();
						
						orderitems.setOrderid(order.getOrderid());
						orderitems.setBookid(cartitems.getBookid());
						orderitems.setQuantity(cartitems.getQuatity());
						orderitems.setPrice(cartitems.getPrice());
				
						orderitemdDAO.addOrderitem(orderitems);	
			}
			
			session.removeAttribute("cart");
			session.setAttribute("order", order);
			response.sendRedirect("orderconfirmationpage.jsp");
		}else {
			
			System.out.println("Order placement failed, staying on the same page");
			response.sendRedirect("Checkout.jsp");	
		}
			
	}
}
