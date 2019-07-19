package com.demo.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.common.page.mybatis.MybatisRepositorySupport;
import com.demo.dao.UserNameDao;
import com.demo.dao.entity.Userinfo;

import freemarker.template.utility.StringUtil;
@Repository
public class UserNameDaoImpl extends MybatisRepositorySupport<String, Userinfo> implements
		UserNameDao {

	
	public Userinfo findById(Map<String, Object> params) {
		//System.out.println(getNamespace());
		Userinfo us =   getSqlSession().selectOne("com.demo.dao.entity.userinfo.findById", params);
		return us;
	}

	public Userinfo findById(Userinfo us) {
		
		Userinfo usk =   getSqlSession().selectOne("com.demo.dao.entity.UserName.findById", us);
		return usk;
	}

	public Userinfo findByUsername(String username, String password) {
		 Map<String, Object> params = new HashMap<String, Object>();
		 if(!StringUtils.isBlank(username))
		 params.put("username", username);
		 if(!StringUtils.isBlank(password))
		 params.put("password", password);
		Userinfo info =  getSqlSession().selectOne(getNamespace()+".findByUsername",params);
		return info;
	}

	public Userinfo findByUsername(String username) {
		return findByUsername(username,null);
	}

	public int add(Userinfo info) {
		return getSqlSession().insert("com.demo.dao.entity.userinfo.save",info);
	}

	

}
