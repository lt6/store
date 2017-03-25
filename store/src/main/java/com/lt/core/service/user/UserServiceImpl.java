package com.lt.core.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.core.bean.User;
import com.lt.core.dao.UserDao;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	public User getUserByUsername(String userName) {
		return userDao.getUserByUsername(userName);
	}

}
