package com.bx.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bx.model.Users;

@Repository
public interface UserMapper {
	public List<Users> userList();
}
