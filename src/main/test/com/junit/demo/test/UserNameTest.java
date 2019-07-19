package com.junit.demo.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.dao.entity.Book;
import com.demo.dao.entity.Userinfo;
import com.demo.service.BookService;
import com.demo.service.UserNameService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/spring/root-context.xml"})
public class UserNameTest {
	
	@Autowired 
	private UserNameService service;
	@Autowired
	private BookService bookService;
	
	@Test
	public void mytest() {
		Map params = new HashMap<String, Object>();
		params.put("id", 1);
		params.put("username", "张三");
		Userinfo us = new Userinfo();
		  us.setAge(9);
		  us.setUsername("小白");
		  us.setPassword("123456");
//		userinfo info = this.service.findByUsername("张三", "123456");
		//userinfo usname = this.service.findById(params);
//		System.out.println(info.getAge());
		  
//		int id=  service.save(us);
//		System.out.println("获取添加的ID:"+us.getId());
		  
		
		//事务测试
		  Userinfo info = new Userinfo();
			info.setAge(23);
			info.setPassword("000000");
			info.setUsername("李白");
		 Book book = new Book("ios", 20, 13);
		  
		 bookService.add(book,info); 
		 
	}
	
	
}
