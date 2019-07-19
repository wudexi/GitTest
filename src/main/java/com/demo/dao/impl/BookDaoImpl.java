package com.demo.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.common.page.mybatis.MybatisRepositorySupport;
import com.demo.dao.BookDao;
import com.demo.dao.entity.Book;
import com.demo.dao.entity.Userinfo;
@Repository
public class BookDaoImpl extends MybatisRepositorySupport<String, Book> implements BookDao {

	public void addBook(Book book) {
		this.getSqlSession().insert(getNamespace()+".save", book);

	}

	public int deleteBook(int id) {
		this.getSqlSession().delete("", id);
		return 0;
	}

	public int updateBook(int id) {
		this.getSqlSession().update("", id);
		return 0;
	}

	public List<Book> list() {
		
		return null;
	}

	public Book getBook(int id) {
		 this.getSqlSession().selectList("", id	);
		return null;
	}

	
	public List<Book> getList(Integer uid) {
		  List<Book> blist = this.getSqlSession().selectList(getNamespace()+".queryList", uid);
		   
		return blist;
	}



}
