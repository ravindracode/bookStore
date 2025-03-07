<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.book.model.User" %>
<%@ page import="com.book.model.Orders" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Confirmation</title>
    <link rel="stylesheet" href="orderconfirmationpage.css">
</head>
<body>
    <div class="container">
        <div class="confirmation-card">
            <div class="check-container">
                <svg class="checkmark" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 52 52">
                    <circle class="checkmark-circle" cx="26" cy="26" r="25" fill="none"/>
                    <path class="checkmark-check" fill="none" d="M14.1 27.2l7.1 7.2 16.7-16.8"/>
                </svg>
            </div>
            <h1 class="title">Order Confirmed!</h1>
            <p class="message">Thank you for your purchase</p>
            
            
            <% 
                HttpSession userSession = request.getSession();
                Orders order = (Orders) userSession.getAttribute("order");
                User user = (User) userSession.getAttribute("user");
                String address = "BTM layout Road-No:210-36 Tavareke,Banglore,Karnataka";
                
                if (order == null || user == null || address == null) {
                    response.sendRedirect("genres.jsp");
                    return;
                }
            %>
            
            
            
            <div class="order-details">
                <div class="detail-item">
                    <span>Order Number:</span>
                    <span><%=order.getOrderid() %></span>
                </div>
                <div class="detail-item">
                    <span>Total Amount:</span>
                    <span><%= order.getTotalamount() %></span>
                </div>
            </div>
            <div class="buttons">
                <button class="track-button">Track Order</button>
                <a href="bestseller" style="text-decoration: none" class="continue-button">Continue Shopping</a>
            </div>
        </div>
    </div>
    <script src="script.js"></script>
</body>
</html>