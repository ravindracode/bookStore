package com.book.DAO;

import java.util.List;

import com.book.model.Book;

public interface BookDAO {

	void addBook(Book book);
	Book getBook(int bookid);
	void updateBook(Book book);
	void deleteBook(int bookid);
	List<Book>getAllBooks();
	List<Book>getAllBooksbyGenres(int genresid);
	
}
