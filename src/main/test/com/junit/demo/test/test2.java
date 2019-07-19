package com.junit.demo.test;


class Base{
	public String name = "abc";
//	public Base(String name) {
//		this.name = name;
//	}
	public void pint() {
		System.out.println("--------"+name+"------");
	}
//	public void introduction(){
//		System.out.println("------introduction-----");
//	}
}
class Child extends Base{

//	public Child(String name) {
//		super(name);
//	}
	public void pint() {
		System.out.println("---------child--------");
		//super.pint();
	}
	public void print() {
		super.pint();
	}
}



public class test2 {
	public static void main(String[] args) {
		Child c = new Child();
		c.print();
//		Base b = new Child("aaa"); 
//		b.pint();
		Base b = new Child();
		b.pint();
		
	}

}
