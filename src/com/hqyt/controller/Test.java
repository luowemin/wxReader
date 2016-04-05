package com.hqyt.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyt.model.User;
import com.hqyt.service.IUserService;

@Controller
@RequestMapping("/controller")
public class Test {
	
	@Resource
	private IUserService userService;
	
	@RequestMapping("/t1")
	@ResponseBody
	public String test(HttpServletRequest request){
		String name = request.getParameter("name");
		if(name == null){
			name = "武汉";
		}
		User user = new User();
		user.setName(name);
		userService.isExit(user);
		return "/html/index.html";
	}
}