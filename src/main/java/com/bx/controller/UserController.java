package com.bx.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
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
				if(null != userList.get(i).getSex() && !("").equals(userList.get(i).getSex())){
					if(userList.get(i).getSex().equals("0")){
						userList.get(i).setSex("男");
					}else if(userList.get(i).getSex().equals("1")){
						userList.get(i).setSex("女");
					}
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
					userList.get(i).setSex("男");
				}else if(userList.get(i).getSex().equals("1")){
					userList.get(i).setSex("女");
				}
			}
		}
		model.addAttribute("userList", userList);
		return "user/userList";
	}
	
	@RequestMapping(value="/toEdit")
	public String toEditUser(@RequestParam String id, ModelMap map){
		if(null == id || ("").equals(id)){
			return "user/edit";
		}
		if(null != userService){
			Users user = userService.searchById(id);
			map.addAttribute("user", user);
		}
		return "user/edit";
	}
	
	@RequestMapping(value="/edit")
	public String editUser(Users user, ModelMap map){
		if(null != userService && null != user){
			if(null == user.getId() || ("").equals(user.getId())){
				userService.addUser(user);
				userService.putKey(user);
				System.out.println(userService.getKey(user).getUsername());
			}else{
				userService.updateUser(user);
			}
		}
		return "redirect:/web/user/userList";
	}
	
	@RequestMapping(value="/delete")
	public String delete(@RequestParam String id){
		if(null != userService){
			Users user = userService.searchById(id);
			if(null != user){
				user.setDeleteFlag("1");
				userService.updateUser(user);
			}
		}
		return "redirect:/web/user/userList";
	}
	
	@RequestMapping(value="/tsdr")
	public String testSDR(){
		Users user1 = new Users("tsdr001", 100);
		Users user2 = new Users("tsdr002", 110);
		userService.putKey(user1);
		userService.putKey(user2);
		return "index";
	}
	
}
