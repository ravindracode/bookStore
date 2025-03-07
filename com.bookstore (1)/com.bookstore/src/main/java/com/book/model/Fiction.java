package com.book.model;

public class Fiction {

	int fictionid;
	String fictionname;
	int price;
	float rating;
	String imagepath;
	String description;
	
	public Fiction() {
		// TODO Auto-generated constructor stub
	}

	public Fiction(int fictionid, String fictionname, int price, float rating, String imagepath, String description) {
		super();
		this.fictionid = fictionid;
		this.fictionname = fictionname;
		this.price = price;
		this.rating = rating;
		this.imagepath = imagepath;
		this.description = description;
	}

	public int getFictionid() {
		return fictionid;
	}

	public void setFictionid(int fictionid) {
		this.fictionid = fictionid;
	}

	public String getFictionname() {
		return fictionname;
	}

	public void setFictionname(String fictionname) {
		this.fictionname = fictionname;
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
