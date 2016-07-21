package com.bx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.bx.dao.interceptor.page.Page;
import com.bx.interceptor.PermissionInterceptor;
import com.bx.model.Test;
import com.bx.model.Users;
import com.bx.service.IUserService;
import com.bx.bean.Result;
import com.bx.common.utils.StringUtil;
import com.bx.common.utils.PageUtil;

@Controller
@RequestMapping("/web/user")
public class UserController {
	private final Logger log = LoggerFactory.getLogger(PermissionInterceptor.class);
	@Resource
	private IUserService userService;
	
	@RequestMapping("/login")
	public String login(){
		log.info("loggggggggggggggggggggggggg");
		return "login";
	}
	
	@RequestMapping(value="/checkLogin")
	public String checkLogin(Users user,HttpServletRequest request){
		if(null != user){
			String password = StringUtil.passwordToMD5(user.getPassword());
			Users loginUser = userService.checkLogin(user.getUserName(), password);
			if(null != loginUser){
				request.getSession().setAttribute("user", loginUser);
				return "index";
			}
		}
		return "login";
	}
	
	/*用户列表一览*/
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
	
	/*检索用户列表*/
	@RequestMapping(value="/search")
	public String searchUsers(@RequestParam("userName") String userName ,ModelMap model, HttpServletRequest request){
		Page<Users> page = new Page<Users>();
		int startIndex = 0;
		int pageSize = page.getPageSize();
		//获取页码
		int pageNo = 1;
		String pageNum = request.getParameter("pageNo");
		if(!StringUtil.isEmpty(pageNum)){
			pageNo = Integer.parseInt(pageNum);
			startIndex = pageNo * page.getPageSize() - page.getPageSize();
			pageSize = pageSize * startIndex;
		}
		//设置limit 第一个值
		page.setStartIndex(startIndex);
		page = userService.searchUsers(page, userName);
		List<Users> userList = page.getRecords();
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
		PageUtil.page(pageNo, page.getPageSize(), page.getTotalRecords(), model);
		return "user/userList";
	}
	
	@RequestMapping(value="/toEdit/{id}", method = RequestMethod.GET)
	public String toEditUser(@PathVariable("id") String id, ModelMap map, HttpServletRequest request, HttpServletResponse response){
		if(null == id || ("").equals(id)){
			return "user/edit";
		}
		if(null != userService){
			Users user = userService.searchById(id);
			map.addAttribute("user", user);
		}
		return "user/edit";
	}
	
	/*编辑用户信息*/
	@RequestMapping(value="/edit")
	public String editUser(Users user, ModelMap map){
		if(null != userService && null != user){
			if(null == user.getId() || ("").equals(user.getId())){
				userService.addUser(user);
				userService.putKey(user);
				System.out.println(userService.getKey(user).getUserName());
			}else{
				userService.updateUser(user);
			}
		}
		return "redirect:/web/user/search";
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
	
	@RequestMapping("/testResult")
	public @ResponseBody Result<List<Users>> testRestul(WebRequest request){
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
		Result<List<Users>> result = new Result<List<Users>>();
		result.setResult(userList);
		return result;
	}
	
	@RequestMapping("/testThread")
	@ResponseBody
	public String singleton(HttpServletRequest request){
		System.out.println("bbb");
		Test.setI(2);
		//String testStr = request.getParameter("test");
		return Test.getI() + "";
	}
	
	@RequestMapping("/testThread1")
	@ResponseBody
	public String singleton1(HttpServletRequest request){
		//String testStr = request.getParameter("test");
		return Test.getI() + "";
	}
	
	@RequestMapping(value="/toRest/{id}")
	@ResponseBody
	public String toRest(@PathVariable("id") String id, ModelMap map){
		List li = new ArrayList();
		if(null == id || ("").equals(id)){
			return "user/edit";
		}
		if(null != userService){
			Users user = userService.searchById(id);
			map.addAttribute("user", user);
		}
		return id;
	}
}
