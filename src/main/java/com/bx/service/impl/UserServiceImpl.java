package com.bx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bx.dao.UserMapper;
import com.bx.model.Users;
import com.bx.service.IUserService;
@Transactional
@Service
public class UserServiceImpl implements IUserService{
	@Resource
	private UserMapper userMapper;

	@Override
	public List<Users> userList() {
		return userMapper.userList();
	}

	@Override
	public List<Users> searchUsers(String userName) {
		return userMapper.searchUsers(userName);
	}

	@Override
	public void addUser() {
		userMapper.addUser();
	}

	
}
