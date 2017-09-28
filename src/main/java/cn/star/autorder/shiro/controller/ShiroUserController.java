package cn.star.autorder.shiro.controller;



import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.star.autorder.shiro.entity.ShiroUser;
import cn.star.autorder.shiro.service.PasswordHelper;
import cn.star.autorder.shiro.service.ShiroService;
import cn.star.autorder.utils.HttpUtils;


/**
 * 登陆控制Controller
 * @author ify
 *
 */
@Controller
public class ShiroUserController {
	@Autowired
	private ShiroService shiroService;
	@Autowired
	private PasswordHelper passwordHelper;
	@Autowired
	private CacheManager loginTokenCacheManager;
	
	/**
	 * 跳转登陆页面
	 * @param model
	 * @param request
	 * @param error 错误代码
	 * @return
	 */
	@RequestMapping("/shiroUserManager/login.htm")
	public String toLoginView(Model model,HttpServletRequest request,String error) {
		Cache loginTokenCache = loginTokenCacheManager.getCache("loginTokenCache");
		String requestIp = HttpUtils.getIpFromRequest(request);
		String loginToken=passwordHelper.createloginToken();
		loginTokenCache.put(requestIp+"_"+loginToken, loginToken);
		model.addAttribute("token",loginToken);
		if(StringUtils.isNotBlank(error)) {
			switch (error) {
			case "maxError":
				model.addAttribute("error", "错误次数过多，请稍后再试！");
				break;
			case "lockErroe":
				model.addAttribute("error", "账户被锁定！");
				break;
			case "passError":
				model.addAttribute("error", "用户名或密码错误");
				break;
			case "nullError":
				model.addAttribute("error", "用户名或密码不能为空!");
				break;
			default:
				model.addAttribute("error", "未知错误，请重新登陆！");
				break;
			}
		}
		return "loginView";
	}
	
	/**
	 * login登陆
	 * @param loginUsername
	 * @param loginPassword
	 * @param tokenKey 登陆唯一性令牌
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/shiroUserManager/loginCheck.htm")
	public String loginCheck(@RequestParam("loginUsername") String loginUsername,
			@RequestParam("loginPassword") String loginPassword,
			@RequestParam("tokenKey") String tokenKey,Model model,
			HttpServletRequest request,HttpServletResponse response) {
		Cache loginTokenCache = loginTokenCacheManager.getCache("loginTokenCache");
		//检查令牌有效性
		if(StringUtils.isNotBlank(tokenKey)) {
			String cacheToken = loginTokenCacheManager.getCache("loginTokenCache").get(HttpUtils.getIpFromRequest(request)+"_"+tokenKey, String.class);
			if(!tokenKey.equals(cacheToken)) {
				model.addAttribute("erroe", "tokenIllegal");
				loginTokenCache.evict(HttpUtils.getIpFromRequest(request)+"_"+tokenKey);
				return "redirect:/shiroUserManager/login.htm";
			}
		}else {
			model.addAttribute("erroe", "tokenIllegal");
			loginTokenCache.evict(HttpUtils.getIpFromRequest(request)+"_"+tokenKey);
			return "redirect:/shiroUserManager/login.htm";
		}
		
		//登陆
		if(StringUtils.isNoneBlank(loginUsername)&&StringUtils.isNoneBlank(loginPassword)) {
			UsernamePasswordToken token=new UsernamePasswordToken(loginUsername.trim(), loginPassword.trim());
			Subject subject = SecurityUtils.getSubject();
			try {
				subject.login(token);
			}catch (ExcessiveAttemptsException  e2) {
				model.addAttribute("error", "maxError");
				loginTokenCache.evict(HttpUtils.getIpFromRequest(request)+"_"+tokenKey);
				return "redirect:/shiroUserManager/login.htm";
			}catch (LockedAccountException e3) {
				// TODO: handle exception
				model.addAttribute("error", "lockedError");
				loginTokenCache.evict(HttpUtils.getIpFromRequest(request)+"_"+tokenKey);
				return "redirect:/shiroUserManager/login.htm";
			}catch (IncorrectCredentialsException|UnknownAccountException e) {
				model.addAttribute("error", "passError");
				loginTokenCache.evict(HttpUtils.getIpFromRequest(request)+"_"+tokenKey);
				return "redirect:/shiroUserManager/login.htm";
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			 ShiroUser shiroUser = shiroService.getUserByUsername(loginUsername);
			 System.out.println(shiroUser);
			 Cookie loginTokenCookie=new Cookie("autorderToken",tokenKey);
			 response.addCookie(loginTokenCookie);
//			 return "index";
			 return "logout";
		}else {
			model.addAttribute("error", "nullError");
			loginTokenCache.evict(HttpUtils.getIpFromRequest(request)+"_"+tokenKey);
			return "redirect:/shiroUserManager/login.htm";
		}
	}
	
	/**
	 * 注销
	 * @param request
	 * @return
	 */
	@RequestMapping("/shiroUserManager/logout.htm")
	public String logout(HttpServletRequest request) {
		Cache loginTokenCache = loginTokenCacheManager.getCache("loginTokenCache");
		String ip = HttpUtils.getIpFromRequest(request);
		String tokenKey=null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if("autorderToken".equals(cookie.getName())) {
				tokenKey=cookie.getValue();
				break;
			}
		}
		loginTokenCache.evict(ip+"_"+tokenKey);
		//cookie不设置时间默认在内存中，关闭页面即消失
		return "redirect:/shiroUserManager/login.htm";
	}
	
	/**
	 * 检查用户是否已登陆
	 * @param request
	 * @return
	 */
	public boolean checkUserlogged(HttpServletRequest request) {
		Cache loginTokenCache = loginTokenCacheManager.getCache("loginTokenCache");
		String ip = HttpUtils.getIpFromRequest(request);
		String tokenKey=null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if("autorderToken".equals(cookie.getName())) {
				tokenKey=cookie.getValue();
				break;
			}
		}
		return StringUtils.isNotEmpty(loginTokenCache.get(ip+"_"+tokenKey, String.class));
	}
	
	@RequestMapping("/ShiroUserManager/toCreateUserView.htm")
	public String toCreateUserView() {
		return "createUserView";
	}
	
	
}
