package com.demo.service;

import java.util.List;

import com.demo.dao.entity.Book;
import com.demo.dao.entity.Userinfo;

public interface BookService {
	public List<Book> getList(Integer uid);
	
	int add(Book book,Userinfo info);
}
