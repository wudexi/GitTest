package com.demo.dao;

import java.util.Map;

import com.demo.dao.entity.Userinfo;

public interface UserNameDao {
  public Userinfo findById(Map<String,Object> params);
  public Userinfo findById(Userinfo us);
  public Userinfo findByUsername(String username,String password);
  public Userinfo findByUsername(String username);
  
  public int add(Userinfo info);
}
