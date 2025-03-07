<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
	<%@ page import="com.book.model.Genres" %>
	<%@ page import="com.book.DAOimpl.GenresDAOimpl" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BookHaven - Your Literary Journey</title>
    <link rel="stylesheet" href="home.css">
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
                <a href="genres" class="active">Home</a>
                <a href="bestseller">Best Sellers</a>
                <a href="fiction">Fiction</a>
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
        <section class="hero">
            <div class="hero-content">
                <h2>Discover Your Next Great Read</h2>
                <p>Explore thousands of books across all genres</p>
                <a href="bestseller" class="cta-button">Browse Books</a>
            </div>
        </section>

        <section class="genres">
            <h2>Featured Books by Genre</h2>
            <div class="genre-grid">
            <%
            List<Genres>genres=(List<Genres>)request.getAttribute("g");
            if(genres != null && !genres.isEmpty()){
            	for(Genres genre:genres){
            
            
            %>
            
                <div class="genre-card">
            
                    <img src=<%= genre.getImagepath() %> alt="Mystery Book Cover" class="book-cover">
                    <div class="card-content">
                        <h3><%=genre.getName() %></h3>                    
                        <p class="book-description"><%= genre.getDescription() %></p>
                        <div class="book-meta">
                            <div class="rating-container">
                                <span class="rating">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" viewBox="0 0 24 24" fill="currentColor" stroke="none">
                                        <polygon points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2"></polygon>
                                    </svg>
                                <span><%=genre.getRating() %></span>
                                </span>
                            </div> 
                            
                            
                        </div>
                        
                        <a href="book?genresid=<%=genre.getGenresid() %>" class="buy-button">Explore</a>
                    </div>
                </div>
            <%
            	}
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