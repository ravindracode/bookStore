package com.book.model;

public class CartItems {
	private int bookid;
	private int genresid;
	private String name;
	private double price;
	private int quatity;
	private String imagepath;
	
	public CartItems() {
		// TODO Auto-generated constructor stub
	}

	public CartItems(int bookid, int genresid, String name, double price, int quatity, String imagepath) {
		super();
		this.bookid = bookid;
		this.genresid = genresid;
		this.name = name;
		this.price = price;
		this.quatity = quatity;
		this.imagepath = imagepath;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuatity() {
		return quatity;
	}

	public void setQuatity(int quatity) {
		this.quatity = quatity;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	
	
}