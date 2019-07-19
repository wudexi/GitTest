package com.demo.web.action;


import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.demo.service.UserNameService;


@Controller
public class UserNameAct {
	@RequestMapping(value="login")
	public String chlogin(ModelMap map, String username,String password) {
		
		try {
//			UsernamePasswordToken token = new UsernamePasswordToken("张三", "123456");
//			Subject subject = SecurityUtils.getSubject();
//			subject.login(token);
			
			SecurityUtils.getSubject().login(new UsernamePasswordToken("张三", "123456"));  
			
		     Object o = (String) SecurityUtils.getSubject().getSession().getAttribute("someKey");
			  System.out.println(o);
		     System.out.println("验证成功");
			return "index";
		} catch (AuthenticationException e) {
			System.out.println("验证失败");
			e.printStackTrace();
			return "faile";
		}
	}
	
	@RequestMapping("/user/book")
	public String book(ModelMap map) {
		
		System.out.println("book");
		
		return "book";
	}
	
	@RequiresPermissions("role:view")
	@RequestMapping("/role/list")
	public String list(ModelMap map) {
		
		System.out.println("list");
		
		return "book";
	}
	
}
