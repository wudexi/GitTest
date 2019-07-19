package com.junit.demo.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.dao.entity.Book;
import com.demo.service.BookService;

public class BookTest extends AbstractTest {
	@Autowired 
	private BookService book;
	
	@Test
	public void list() {
		List<Book> data =book.getList(1);
		for (Book book : data) {
			System.out.println(book.getBookname());
		}
	}
	
	
}
