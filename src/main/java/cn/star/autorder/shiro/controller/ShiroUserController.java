package cn.star.autorder.shiro.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.star.autorder.shiro.entity.ShiroUser;
import cn.star.autorder.shiro.service.PasswordHelper;
import cn.star.autorder.shiro.service.ShiroService;

@Controller
public class ShiroUserController {
	@Autowired
	private ShiroService shiroService;
	@Autowired
	private PasswordHelper passwordHelper;
	
	@RequestMapping("/shiroUserManager/login.htm")
	public String toLoginView() {
		return "login";
	}
	
	@RequestMapping("/shiroUserManager/loginCheck.htm")
	public String loginCheck(@RequestParam("loginUsername") String loginUsername,
			@RequestParam("loginPassword") String loginPassword,
			@RequestParam("tokenKey") String tokenKey,Model model) {
		
		ShiroUser user=new ShiroUser();
		user.setLocked(1);
		user.setUsername("xiaoming");
		user.setPassword("admin");
		passwordHelper.encryptPassword(user);
		ShiroUser createUser = shiroService.createUser(user);
		System.out.println(createUser);
//		if(StringUtils.isNoneBlank(loginUsername)&&StringUtils.isNoneBlank(loginPassword)) {
//			UsernamePasswordToken token=new UsernamePasswordToken(loginUsername.trim(), loginPassword.trim());
//			Subject subject = SecurityUtils.getSubject();
//			try {
//				subject.login(token);
//			} catch (IncorrectCredentialsException|UnknownAccountException e) {
//				model.addAttribute("error", "用户名或密码错误！");
//				return "login";
//			}catch (ExcessiveAttemptsException  e2) {
//				model.addAttribute("error", "错误次数过多，请稍后再试！");
//				return "login";
//			}
//			 ShiroUser shiroUser = shiroService.findByUsername(loginUsername);
//			 return "index";
//		}else {
//			model.addAttribute("error", "用户名密码不可为空");
//			return "login";
		return "login";
	}
}
