package com.bx.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bx.dao.UserMapper;
import com.bx.dao.interceptor.page.Page;
import com.bx.model.Users;
import com.bx.service.IUserService;
import com.bx.service.base.BaseServiceImpl;
@Transactional
@Service("usersService")
public class UserServiceImpl extends BaseServiceImpl<Users, String, UserMapper> implements IUserService{

	@Resource
	private UserMapper userMapper;
	
	@Resource
	private RedisTemplate<String, Users> redisTemplate;
	
	@Override
	public List<Users> userList() {
		return basedao.userList();
	}

	@Override
	public Page<Users> searchUsers(Page<Users> page, String userName) {
		return userMapper.searchUsers(page, userName);
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
	
	Map<String, Object> map = new HashMap<String, Object>();
	
	public void putKey(Users user){
		Map<String, Object> hash = new HashMap<String, Object>();
		hash.put("name", user);
		redisTemplate.opsForHash().putAll("user", hash);
		//redisTemplate.opsForHash().put(user.getOBJECT_KEY(), user.getKey(), user);
	}
	
	public void deleteKey(Users user){
		redisTemplate.opsForHash().delete(user.getOBJECT_KEY(), user.getKey());
	}
	
	public Users getKey(Users user){
		//return (Users) redisTemplate.opsForHash().get(user.getOBJECT_KEY(), user.getKey());
		return (Users) redisTemplate.opsForHash().get("user", "name");
	}

	@Override
	public Users checkLogin(String userName, String password) {
		return userMapper.checkLogin(userName, password);
	}
}
