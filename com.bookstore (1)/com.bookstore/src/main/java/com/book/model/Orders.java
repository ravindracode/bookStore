package com.book.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Orders {

	private int orderid;
	private int userid;
	private int genresid;
	private Timestamp orderdate;
	private double totalamount;
	private String status;
	private String paymentmode;
	private List<Orderitems>Orderitems;
	
	public Orders() {
			this.orderdate = new Timestamp(System.currentTimeMillis());
			this.Orderitems = new ArrayList<>();
	
	}

	public Orders(int orderid, int userid, int genresid, Timestamp orderdate, double totalamount, String status,
			String paymentmode) {
		super();
		this.orderid = orderid;
		this.userid = userid;
		this.genresid = genresid;
		this.orderdate = orderdate;
		this.totalamount = totalamount;
		this.status = status;
		this.paymentmode = paymentmode;
		
	}

	

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getGenresid() {
		return genresid;
	}

	public void setGenresid(int genresid) {
		this.genresid = genresid;
	}

	public Timestamp getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Timestamp orderdate) {
		this.orderdate = orderdate;
	}

	public double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

	public List<Orderitems> getOrderitems() {
		return Orderitems;
	}

	public void setOrderitems(List<Orderitems> orderitems) {
		Orderitems = orderitems;
	}
	
	
	
	
}
