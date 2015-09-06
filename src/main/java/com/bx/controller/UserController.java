package com.bx.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bx.model.Users;
import com.bx.service.IUserService;

@Controller
@RequestMapping("/web/user")
public class UserController {
	@Resource
	private IUserService userService;

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
		if(null != userList && userList.size() > 0){
			for(int i = 0; i < userList.size(); i++){
				if(userList.get(i).getSex().equals("0")){
					userList.get(i).setSex("ÄÐ");
				}else if(userList.get(i).getSex().equals("1")){
					userList.get(i).setSex("Å®");
				}
			}
		}
		model.addAttribute("userList", userList);
		return "user/userList";
	}
	
	@RequestMapping(value="/search")
	public String searchUsers(@RequestParam("userName") String userName ,Model model){
		List<Users> userList = userService.searchUsers(userName);
		if(null != userList && userList.size() > 0){
			for(int i = 0; i < userList.size(); i++){
				if(userList.get(i).getSex().equals("0")){
					userList.get(i).setSex("ÄÐ");
				}else if(userList.get(i).getSex().equals("1")){
					userList.get(i).setSex("Å®");
				}
			}
		}
		model.addAttribute("userList", userList);
		return "user/userList";
	}
	
	public String addUser(ModelMap map){
		if(null != userService){
			userService.addUser();
		}
		return "user/userList";
	}
}
