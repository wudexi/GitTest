package com.junit.demo.test;

import java.util.Date;

class A{
	private int i ;
	private Date time;
	private B b;
	public A(int i, Date time) {
		super();
		this.i = i;
		this.time = time;
	}
	
	public A(int i, Date time, B b) {
		super();
		this.i = i;
		this.time = time;
		this.b = b;
	}

	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public B getB() {
		return b;
	}
	public void setB(B b) {
		this.b = b;
	}
	
}
class B{
	private int x;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
}
public class test9 {

	public static void main(String[] args) {
		A a = new A(1,new Date(),new B());
//		Date d = a.getTime();
//		System.out.println(d.toLocaleString());
//		System.out.println(d.getTime());
//		System.out.println(d.getDay());
//		System.out.println(d.getMonth());
//		System.out.println(d.toLocaleString());
		B b = a.getB();
		System.out.println(b.getX());
		b.setX(1);
		System.out.println(a.getB().getX());
		
	}

}
