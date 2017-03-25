package com.lt.core.service.user;

import com.lt.core.bean.User;


public interface UserService {
	/**
	 * 根据用户名查询
	 */
	public User getUserByUsername(String userName);
}
