package com.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserNameDao;
import com.demo.dao.entity.Userinfo;
import com.demo.service.UserNameService;
import com.google.common.collect.Lists;
@Service
public class UserNameServiceImpl implements UserNameService {
	@Autowired
	private UserNameDao userNameDao;

	@Override
	public Userinfo findById(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return userNameDao.findById(params);
	}
	

	@Override
	public Userinfo findById(Userinfo us) {
		
		return userNameDao.findById(us);
	}
	@Override
	public Userinfo findByUsername(String username, String password) {
		return userNameDao.findByUsername(username, password);
	}


	@Override
	public Userinfo findByUsername(String username) {
//		Subject currentUser = SecurityUtils.getSubject();
//		Session session = currentUser.getSession();
//		session.setAttribute("someKey", "holleword");
		// TODO Auto-generated method stub
		return userNameDao.findByUsername(username);
	}


	public int save(Userinfo info) {
		
		return userNameDao.add(info);
	}

	/**
	 * 角色
	 */
	@Override
	public List<String> findByRole(String username) {
		// TODO Auto-generated method stub
		List<String> list = Lists.newArrayList();
		list.add("001");
		return list;
	}
}
