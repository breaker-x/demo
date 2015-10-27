package com.bx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bx.dao.base.BaseMapper;
import com.bx.dao.interceptor.page.Page;
import com.bx.model.Users;

public interface UserMapper extends BaseMapper<Users, String>{
	/*验证登录是否合法*/
	public Users checkLogin(@Param("userName") String userName, @Param("password") String password);
	
	public List<Users> userList();
	
	public Page<Users> searchUsers(@Param("page") Page<Users> page, @Param("userName") String userName);
	
	public void addUser(Users user);
	
	public Users searchById(@Param("id") String id);
	
	public void updateUser(Users user);
}
