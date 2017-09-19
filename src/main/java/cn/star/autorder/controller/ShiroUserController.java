package cn.star.autorder.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.star.autorder.shiro.service.ShiroService;

@Controller
public class ShiroUserController {
	@Autowired
	private ShiroService shiroService;
	
	@RequestMapping("/shiroUserManager/login.htm")
	public String toLoginView() {
		return "login";
	}
	
	@RequestMapping("/shiroUserManager/loginCheck.htm")
	public String loginCheck(HttpServletRequest request,Model model) {
		String loginUsername = request.getParameter("loginUsername");
		String loginPassword = request.getParameter("loginPassword");
		System.out.println(loginPassword+" "+loginUsername);
		model.addAttribute("error", "用户名或密码错误!");
		return "login";
	}
}
