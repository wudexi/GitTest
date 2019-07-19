package com.test.clone;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.google.common.collect.Maps;

public class Sudent {
	private String name;
	private int age;
	private Map<String,Object> map = Maps.newHashMap();
	
	
	public Sudent() {
		super();
	}
	public Sudent(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return "Sudent [name=" + name + ", age=" + age + "]";
	}
	public static void main(String[] args) {
		Sudent s = new Sudent();
//		Sudent s2 = new Sudent();
//		s.map.put("1", "s");
//		
//		try {
//			BeanUtils.copyProperties(s, s2);
//			s2.map.put("1", "s2");
//			System.out.println(s.map.get("1"));
//			System.out.println(s2.map.get("1"));
//		} catch (IllegalAccessException | InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		s.setName("张三");
		s.setAge(1);
		
		new Thread( new Runnable() {
			@Override
			public void run() {
				s.setAge(2);
			}
		}).start();
		
		System.out.println(s.toString());
		int xx = Runtime.getRuntime().availableProcessors() ;
		System.out.println(xx);
	}
}
