package com.lt.core.dao;

import com.lt.core.bean.User;


public interface UserDao {
	public User getUserByUsername(String userName);
}
