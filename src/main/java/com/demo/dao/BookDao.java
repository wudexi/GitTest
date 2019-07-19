package com.demo.dao;

import java.util.List;

import com.demo.dao.entity.Book;

public interface BookDao  {
	public void addBook(Book book);
	public int  deleteBook(int id);
	public int  updateBook(int id);
	public List<Book> list();
	public Book getBook(int id);
	public List<Book> getList(Integer uid);
	
}
