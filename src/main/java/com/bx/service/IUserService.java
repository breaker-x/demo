package com.bx.service;

import java.util.List;

import com.bx.model.Users;

public interface IUserService {
	public List<Users> userList();
	public List<Users> searchUsers(String userName);
	public void addUser();
}
