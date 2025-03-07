package com.book.model;

public class Genres {

	private int genresid;
	private String name;
	private float rating;
	private String description;
	private String imagepath;
	private int adminuserid;
	
	public Genres() {
		// TODO Auto-generated constructor stub
	}

	public Genres(int genresid, String name, float rating, String description, String imagepath, int adminuserid) {
		super();
		this.genresid = genresid;
		this.name = name;
		this.rating = rating;
		this.description = description;
		this.imagepath = imagepath;
		this.adminuserid = adminuserid;
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

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public int getAdminuserid() {
		return adminuserid;
	}

	public void setAdminuserid(int adminuserid) {
		this.adminuserid = adminuserid;
	}
	
	
	
	
	
	
	
	
	
	
	
}
