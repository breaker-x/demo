package com.bx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bx.dao.UserMapper;
import com.bx.model.Users;
import com.bx.service.IUserService;
import com.bx.service.base.BaseServiceImpl;
@Transactional
@Service
public class UserServiceImpl extends BaseServiceImpl<Users, String, UserMapper> implements IUserService{

	@Resource
	private UserMapper userMapper;
	
	@Override
	public List<Users> userList() {
		return basedao.userList();
	}

	@Override
	public List<Users> searchUsers(String userName) {
		return userMapper.searchUsers(userName);
	}

	@Override
	public void addUser(Users user) {
		basedao.addUser(user);
	}

	@Override
	public Users searchById(String id) {
		return basedao.selectByPrimaryKey(id);
	}

	@Override
	public void updateUser(Users user) {
		basedao.updateByPrimaryKey(user);
	}
}
