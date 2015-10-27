package com.bx.service;


import java.util.List;

import com.bx.dao.interceptor.page.Page;
import com.bx.model.Users;
import com.bx.service.base.IBaseService;

public interface IUserService extends IBaseService<Users, String>{
	public Users checkLogin(String userName, String password);
	
	public List<Users> userList();
	
	public Page<Users> searchUsers(Page<Users> page, String userName);

	public void addUser(Users user);
	
	public Users searchById(String id);
	
	public void updateUser(Users user);
	
	public void putKey(Users user);
	
	public void deleteKey(Users key);
	
	public Users getKey(Users key);
}
