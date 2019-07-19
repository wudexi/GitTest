package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.BookDao;
import com.demo.dao.UserNameDao;
import com.demo.dao.entity.Book;
import com.demo.dao.entity.Userinfo;
import com.demo.service.BookService;
import com.demo.service.UserNameService;
@Service
@Transactional
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao dao;
	
	@Autowired
	private UserNameDao userNameDao;
	
	@Transactional(readOnly=true)
	public List<Book> getList(Integer uid) {
		
		return this.dao.getList(uid);
	}

	public int add(Book book,Userinfo info) {
		
		dao.addBook(book);
		
		userNameDao.add(info);
		return 0;
	}

}
