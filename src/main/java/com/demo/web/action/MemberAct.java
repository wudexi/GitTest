package com.demo.web.action;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/member")
@Controller
public class MemberAct {
	
	@RequiresRoles("001")
	@RequestMapping("/list")
	public String list() {
		return "member/list";
	}
	
	
	
}
