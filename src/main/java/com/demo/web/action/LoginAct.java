package com.demo.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class LoginAct {
	@RequestMapping("/success")
	public String login() {
		
		
		return "success";
	}
}
