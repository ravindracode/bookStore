package com.book.model;

public class Orderitems {
	private int orderitemsid;
	private int orderid;
	private int bookid;
	private int quantity;
	private double price;
	
	public Orderitems() {
		// TODO Auto-generated constructor stub
	}

	public Orderitems(int orderitemsid, int orderid, int bookid, int quantity, double price) {
		super();
		this.orderitemsid = orderitemsid;
		this.orderid = orderid;
		this.bookid = bookid;
		this.quantity = quantity;
		this.price = price;
	}

	public int getOrderitemsid() {
		return orderitemsid;
	}

	public void setOrderitemsid(int orderitemsid) {
		this.orderitemsid = orderitemsid;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
