package com.demo.dao.entity;

public class Book {
	private int bid;
	private String bookname;
	private double  price;
	private int uid;
	public Book() {
		super();
	}


	
	public Book(int bid, String bookname, double price, int uid) {
		super();
		this.bid = bid;
		this.bookname = bookname;
		this.price = price;
		this.uid = uid;
	}



	public Book(String bookname, double price, int uid) {
		super();
		this.bookname = bookname;
		this.price = price;
		this.uid = uid;
	}



	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
