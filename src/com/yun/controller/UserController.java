package com.yun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yun.pojo.User;
import com.yun.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * ç™»å½•
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request, User user) {

		return "login";
	}

	/**
	 * ×¢²á
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping("/regist")
	public String regist(HttpServletRequest request, User user) {
		if (user.getUsername() == null || user.getPassword() == null) {
			return "regist";
		} else {
			if (userService.addUser(user)) {
				return "login";
			} else {
				request.setAttribute("msg", "×¢²á³É¹¦£¡");
				return "regist";
			}
		}

	}

	/**
	 * ç™»å‡º
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/user/login.action";
	}

}
