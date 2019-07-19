package com.demo.service;

import java.util.List;
import java.util.Map;

import com.demo.dao.entity.Userinfo;

public interface UserNameService {
	 public Userinfo findById(Map<String,Object> params);
	 public Userinfo findById(Userinfo us);
	 public Userinfo findByUsername(String username,String password);
	 public Userinfo findByUsername(String username);
	 
	 int save(Userinfo info);
	 List<String> findByRole(String username);
	 
}
