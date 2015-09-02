package com.bx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bx.dao.UserMapper;
import com.bx.model.Users;
import com.bx.service.IUserService;
@Transactional
@Service
public class UserServiceImpl implements IUserService{
	@Resource
	UserMapper userMapper;

	@Override
	public List<Users> userList() {
		return userMapper.userList();
	}

}
