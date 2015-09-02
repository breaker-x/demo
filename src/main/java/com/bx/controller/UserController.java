package com.bx.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bx.model.Users;
import com.bx.service.IUserService;

@Controller
@RequestMapping("/web/user")
public class UserController {
	@Resource
	IUserService userService;

	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/checkLogin")
	public String checkLogin(Model model,@RequestParam String userName, @RequestParam String password){
		model.addAttribute("userName", userName);
		model.addAttribute("password", password);
		return "index";
	}
	
	@RequestMapping(value="/userList")
	public String userList(Model model){
		List<Users> userList = userService.userList();
		model.addAttribute("age", userList.get(0).getAge());
		return "userList";
	}
}
