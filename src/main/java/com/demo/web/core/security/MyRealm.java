package com.demo.web.core.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.dao.entity.Book;
import com.demo.dao.entity.Userinfo;
import com.demo.service.BookService;
import com.demo.service.UserNameService;

public class MyRealm extends AuthorizingRealm {
	public static Logger log = LoggerFactory.getLogger(MyRealm.class);
	@Autowired 
	private UserNameService service;
	@Autowired 
	private BookService bookserivce;
	/**
	 * 授权
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		log.info("授权。。。。。。。");
//		String username = (String) principals.fromRealm(getName()).iterator().next();
//		if(username != null){
//			Userinfo info = service.findByUsername(username);
//			if(info !=null && info.getUsername()!= null){
//				SimpleAuthorizationInfo sinfo = new SimpleAuthorizationInfo();
//				
//				List<String> list =  service.findByRole(username);
//				sinfo.addRoles(list);
//				
////				List<Book> blist = bookserivce.getList(1);
////				Set<String> param = new HashSet<String>();
////				for (Book b : blist) {
////					if(b!=null)
////					param.add(b.getBookname());
////				}
////				sinfo.setStringPermissions(param);
//				
//				return sinfo;
//			}
//		}
//		 
//		return null;
//		
		String username = (String)principals.getPrimaryPrincipal();  
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();  
        List<String> list =  service.findByRole(username);
        authorizationInfo.addRoles(list);
        return authorizationInfo;  
		
		
	}

	/**
	 * 登录认证
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {

			log.info("登录认证。。。。。。。");
		  UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		  String userName = token.getUsername();
		 if(userName!=null && !"".equals(userName)){
			 Userinfo info = service.findByUsername(userName);
			 if(info!=null){
				 return new SimpleAuthenticationInfo(info.getUsername(),info.getPassword(),getName());
			 }
		 }
		return null;
	}

}
