package com.bx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/web/user")
public class UserController {
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
	
	public String userList(){
		
		return "userList";
	}
}
