<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.book.model.Cart, com.book.model.CartItems" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Cart</title>
    <link rel="stylesheet" href="cart.css">
</head>
<body>
    <div class="cart-page">
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null || cart.getItems().isEmpty()) {
        %>
        <div class="cart-empty">
            <h2>Your Cart is Empty</h2>
            <p>Browse our collection and add books to your cart.</p>
            <a href="genres" style="text-decoration: none;"class="add-items-button">Add Books</a>
        </div>
        <%
            } else {
            	int genresid=0;
            	if(!cart.getItems().isEmpty()){
            		genresid=cart.getItems().values().iterator().next().getGenresid();
            	}
        %>
        <h1>Your Cart</h1>
        <div class="cart-container">
        <div class="cart-items">
            <% 
                double totalAmount = 0;
                int totalItems = 0;
                for (Map.Entry<Integer, CartItems> entry : cart.getItems().entrySet()) {
                    CartItems book = entry.getValue();
                    totalAmount += book.getPrice() * book.getQuatity();
                    totalItems += book.getQuatity();
            %>
            <div class="cart-item">
                <img src="<%=book.getImagepath()%>" alt="<%= book.getName() %>" class="cart-item-image">
                <div class="cart-item-details">
                    <h3><%= book.getName() %></h3>
                    <p class="cart-item-price">₹<%= book.getPrice() %></p>
                    <div class="cart-item-controls">
                        <form action="cart" method="post" style="display:inline;">
                            <input type="hidden" name="action" value="update">
                            <input type="hidden" name="bookid" value="<%= book.getBookid() %>">
                            <input type="hidden" name="quantity" value="<%= book.getQuatity() - 1 %>">
                            <button type="submit" class="quantity-btn" <% if (book.getQuatity() <= 1) { %> disabled <% } %>>-</button>
                        </form>
                        <input type="number" value="<%= book.getQuatity() %>" readonly class="quantity-input">
                        <form action="cart" method="post" style="display:inline;">
                            <input type="hidden" name="action" value="update">
                            <input type="hidden" name="bookid" value="<%= book.getBookid() %>">
                            <input type="hidden" name="quantity" value="<%= book.getQuatity() + 1 %>">
                            <button type="submit" class="quantity-btn">+</button>
                        </form>
                        <form action="cart" method="post">
                            <input type="hidden" name="action" value="remove">
                            <input type="hidden" name="bookid" value="<%= book.getBookid() %>">
                            <button type ="submit" class="remove-btn">
                                <svg width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                    <path d="M3 6h18"></path>
                                    <path d="M19 6v14c0 1-1 2-2 2H7c-1 0-2-1-2-2V6"></path>
                                    <path d="M8 6V4c0-1 1-2 2-2h4c1 0 2 1 2 2v2"></path>
                                </svg>
                                Remove
                            </button>
                        </form>
                    </div>
                </div>
            </div>
            <% } %>
        <button class="add-more-btn" onclick="location.href='book?genresid=<%= genresid %>'">Add More Items</button>
        </div>
        <div class="cart-summary">
            <h2>Order Summary</h2>
            <div class="summary-items">
                <div class="summary-item subtotal">
                    <span>Total Items</span>
                    <span><%= totalItems %></span>
                </div>
                <div class="summary-item total">
                    <span>Total</span>
                    <span>₹<%= totalAmount %></span>
                </div>
            </div>
            <a href="Checkout.jsp" style="text-decoration: none;" class="checkout-button">Checkout</a>
        </div>
        <% } %>
        </div>
    </div>
</body>
</html>
