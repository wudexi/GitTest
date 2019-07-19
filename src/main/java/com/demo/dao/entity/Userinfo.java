package com.demo.dao.entity;

public class Userinfo {
	private int id;
	private String username;
	private int age;
	private String password;
	
	public Userinfo() {
		super();
	}
	public Userinfo(int id, String username, int age) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
	}
	
	public Userinfo(int id, String username, int age, String password) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
