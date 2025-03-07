package com.book.model;

public class Book {

	private int bookid;
	private int genresid;
	private String bookname;
	private int price;
	private float rating;
	private String imagepath;
	private String description;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int bookid, int genresid, String bookname, int price, float rating, String imagepath,
			String description) {
		super();
		this.bookid = bookid;
		this.genresid = genresid;
		this.bookname = bookname;
		this.price = price;
		this.rating = rating;
		this.imagepath = imagepath;
		this.description = description;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getGenresid() {
		return genresid;
	}

	public void setGenresid(int genresid) {
		this.genresid = genresid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
