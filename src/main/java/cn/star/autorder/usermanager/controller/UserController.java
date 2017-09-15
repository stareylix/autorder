package cn.star.autorder.usermanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.star.autorder.usermanager.service.IUserService;

@Controller
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/welcome.htm")
	public String login() {
		userService.login();
		return "www";
	}
}
