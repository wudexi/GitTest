package com.junit.demo.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.dao.entity.Userinfo;
import com.demo.service.UserNameService;

public class LoginTest extends AbstractTest {
	@Autowired
	private UserNameService userName;
	
	@Test
	public void print() {
		Userinfo info = userName.findByUsername("张三");
		System.out.println(info.getUsername());
	}
}
