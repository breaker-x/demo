package com.bx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.bx.model.Users;

public interface UserMapper {
	public List<Users> userList();
	public List<Users> searchUsers(@Param("userName") String userName);
	public void addUser();
}
