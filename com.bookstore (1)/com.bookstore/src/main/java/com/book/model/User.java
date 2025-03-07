package com.book.model;

import java.sql.Timestamp;

public class User {

	private int userid;
	private String name;
	private String password;
	private String email;
	private Timestamp createddate;
	private Timestamp lastlogindate;
	
	public User() {
			
		this.createddate = new Timestamp(System.currentTimeMillis());
		this.lastlogindate = new Timestamp(System.currentTimeMillis());
	}

	public User(int userid, String name, String password, String email, Timestamp createddate,
			Timestamp lastlogindate) {
		super();
		this.userid = userid;
		this.name = name;
		this.password = password;
		this.email = email;
		this.createddate = createddate;
		this.lastlogindate = lastlogindate;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}

	public Timestamp getLastlogindate() {
		return lastlogindate;
	}

	public void setLastlogindate(Timestamp lastlogindate) {
		this.lastlogindate = lastlogindate;
	}
	 
	

	
}
