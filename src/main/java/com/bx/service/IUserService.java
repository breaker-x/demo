package com.bx.service;


import java.util.List;

import com.bx.model.Users;
import com.bx.service.base.IBaseService;

public interface IUserService extends IBaseService<Users, String>{
	public List<Users> userList();
	
	public List<Users> searchUsers(String userName);

	public void addUser(Users user);
	
	public Users searchById(String id);
	
	public void updateUser(Users user);
}
