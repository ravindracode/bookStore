package com.book.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.book.DAO.BookDAO;
import com.book.connection.SQLConnection;
import com.book.model.Book;

public class BookDAOimpl implements BookDAO {

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book getBook(int bookid) {
			String GET_BOOK_QUREY="SELECT * FROM book WHERE bookid=?";
		
		try(Connection connection = SQLConnection.connect();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_BOOK_QUREY)) {
			
			preparedStatement.setInt(1, bookid);
			
			 ResultSet res = preparedStatement.executeQuery();
			 
			 if(res.next()) {
				 return extractBook(res);
			 }
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBook(int bookid) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Book> getAllBooks() {
		String GET_ALL_BOOKS="SELECT * FROM `book`";
				ArrayList<Book> booklist = new ArrayList<>();
				
				try(Connection connection=SQLConnection.connect();
						Statement statement=connection.createStatement()){
					
					ResultSet res = statement.executeQuery(GET_ALL_BOOKS);
					
					while(res.next()) {
						booklist.add(extractBook(res));
					}
			
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				return booklist;
	}
	
	

	@Override
	public List<Book> getAllBooksbyGenres(int genresid) {

		String GET_ALL_BOOK_QUERY="SELECT * FROM `book` WHERE `genresid`=?";
		ArrayList<Book> bookList = new ArrayList<>();
		
	    try (Connection connection = SQLConnection.connect();
		         PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BOOK_QUERY)) {
		        
		        preparedStatement.setInt(1, genresid);
		        ResultSet res = preparedStatement.executeQuery();

		        while (res.next()) {
		            Book book = extractBook(res);
		            bookList.add(book);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return bookList;
		}

	
	
	
	
	
		private Book extractBook(ResultSet res) throws SQLException {
		    int bookid = res.getInt("bookid");
		    int genresid = res.getInt("genresid");
		    String bookname = res.getString("bookname");
		    int price = res.getInt("price");
		    float rating = res.getFloat("rating");
		    String imagepath = res.getString("imagepath");
		    String description = res.getString("description");

		    return new Book(bookid, genresid, bookname, price, rating, imagepath, description);
		}
		
		
		
		
		public static void main(String[] args) {
			int count=0;
			BookDAOimpl bookDAOimpl = new BookDAOimpl();
					List<Book> allBooks = bookDAOimpl.getAllBooks();
					for (Book book : allBooks) {
						if(book==book) {
							count++;
						}
					}
					System.out.println(count);
		
		
	
	}

		

}
