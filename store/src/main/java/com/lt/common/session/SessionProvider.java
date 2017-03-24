package com.lt.common.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SessionProvider {
	
	public void setAttribute(HttpServletRequest request,String name ,Serializable value);
	//获取Session中的值
	public Serializable getAttribute(HttpServletRequest request,String name);
	
	//退出登陆
	public void logout(HttpServletRequest request,HttpServletResponse response);
	
	//获取Session Id
	public String getSessionId(HttpServletRequest request);
}


