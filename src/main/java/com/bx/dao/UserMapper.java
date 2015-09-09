package com.bx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bx.dao.base.BaseMapper;
import com.bx.model.Users;

public interface UserMapper extends BaseMapper<Users, String>{
	public List<Users> userList();
	
	public List<Users> searchUsers(@Param("userName") String userName);
	
	public void addUser(Users user);
	
	public Users searchById(@Param("id") String id);
	
	public void updateUser(Users user);
}
