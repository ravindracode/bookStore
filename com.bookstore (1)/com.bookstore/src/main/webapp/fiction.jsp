<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.book.model.Fiction,com.book.DAO.FictionDAO,com.book.DAOimpl.FictionDAOimpl,java.util.List" %>   
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BookHaven - Your Literary Journey</title>
    <link rel="stylesheet" href="book.css">
</head>
<body>
    <header>
        <nav class="navbar">
            <div class="logo">
                <span>📚</span>
                <a href="genres" style="text-decoration: none; color: white;">
                    <h1>BookHaven</h1>
                </a>
            </div>
            <div class="search-container">
                <input type="text" placeholder="Search books, authors, genres..." class="search-input">
                <button class="search-button">🔍</button>
            </div>
            <div class="nav-links">
                <a href="genres" >Home</a>
                <a href="bestseller">Best Sellers</a>
                <a href="#"class="active">Fiction</a>
                <a href="login.html">Login</a>
                <a href="cart.jsp">Cart</a>
            </div>
            <button class="hamburger">
                <span></span>
                <span></span>
                <span></span>
            </button>
        </nav>
    </header>

    <main>
    <section class="genres">
            <h2>Featured Books by Fiction</h2>
            <div class="genre-grid">
                
				<%
				
				List<Fiction>fiction=(List<Fiction>)request.getAttribute("f");
				if(fiction != null && !fiction.isEmpty()){
					for(Fiction fictions:fiction){
				
						
					
				%>
				<div class="genre-card">
						    <img src="<%=fictions.getImagepath() %>" alt="Book Cover" class="book-cover">
						    <div class="card-content">
						       
						        <div class="book-author"><%= fictions.getFictionname() %></div>
						        <p class="book-description"><%= fictions.getDescription() %></p>
						        <div class="book-meta">
						            <div class="rating-price-container">
						                <span class="rating">
						                    <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" viewBox="0 0 24 24" fill="currentColor" stroke="none">
                                        <polygon points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2"></polygon>
                                    </svg> <%= fictions.getRating()%>
						                </span>
						                <span class="book-price">₹<%= fictions.getPrice()%></span>
						            </div>
						        </div>
						         <form action="cart" method="post">
						        		<input type="hidden" name="action" value="add"></input>
						        		<input type="hidden" name="fictionid" value="<%= fictions.getFictionid() %>"></input>
						        	 	<button type="submit" class="buy-button">Add to Cart</button>
						        </form>
						    </div>
						</div>
					<%
					}
				}
				else{
					
					 
	                %>
	                <h1>No Fictions items available.</h1>
	                <% 
	                    } 
	                %>	
            </div>
        </section>
    </main>

    <footer>
        <div class="footer-content">
            <div class="footer-section">
                <h3>BookHaven</h3>
                <p>Your journey through literature starts here</p>
            </div>
            <div class="footer-section">
                <h3>Quick Links</h3>
                <a href="#">About Us</a>
                <a href="#">Contact</a>
                <a href="#">Privacy Policy</a>
            </div>
            <div class="footer-section">
                <h3>Connect</h3>
                <div class="social-links">
                    <a href="#">Facebook</a>
                    <a href="#">Twitter</a>
                    <a href="#">Instagram</a>
                </div>
            </div>
        </div>
        <div class="footer-bottom">
            <p>&copy; 2024 BookHaven. All rights reserved.</p>
        </div>
    </footer>

    <script src="home.js"></script>
</body>
</html>
    