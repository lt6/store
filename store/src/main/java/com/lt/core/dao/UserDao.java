package com.lt.core.dao;

import com.lt.core.bean.User;


public interface UserDao {
	//登录查询 
	public User getUserByUsername(String userName);
}
