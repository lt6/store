package com.lt.common.session;

import java.io.Serializable;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lt.common.Constants;



/**
 * Session提供类
 * @author lx
 *
 */
public class HttpSessionProvider implements SessionProvider{

	
	//往Session中设置值
	public void setAttribute(HttpServletRequest request,String name ,Serializable value){
		HttpSession session = request.getSession();
		if(session != null){
			session.setAttribute(name, value);
		}
	}
	//获取Session中的值
	public Serializable getAttribute(HttpServletRequest request,String name){
		HttpSession session = request.getSession(false);
		if(session != null){
			return (Serializable) session.getAttribute(name);
		}else{
			return null;
		}
	}
	//退出登陆
	public void logout(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession(false);
		if(session != null){
			session.invalidate();
		}
		Cookie c  = new Cookie(Constants.UER_SESSION,null);
		c.setMaxAge(0);
		response.addCookie(c);
	}
	//获取Session Id
	public String getSessionId(HttpServletRequest request){
		return request.getRequestedSessionId();
	}
	
}

