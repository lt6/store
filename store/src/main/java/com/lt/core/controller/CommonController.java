package com.lt.core.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lt.common.ResponseUtils;
import com.lt.common.session.SessionProvider;

import com.lt.web.Constants;



@Controller
public class CommonController extends HttpServlet{
	
/*	@Autowired
	private SessionProvider sessionProvider;
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "/index.do")
	public String index(HttpServletRequest request,ModelMap model){
		//加载用户
		Person user = (Person) sessionProvider.getAttribute(request, Constants.PERSON_SESSION);
		//Buyer b = buyerService.getBuyerByKey(buyer.getUsername());
		model.addAttribute("user", user);
		return "index";
	}*/
	@RequestMapping(value = "/login")
	public String login(){
		return "login";
	}
	/*@RequestMapping(value = "/login.do")
	public void login (HttpServletRequest request,HttpServletResponse response,ModelMap model){
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			Person user=personService.getPersonByUsername(userName);
			if(user.getPassword().equals(password)){
				System.out.println(user.getPassword());
			//把用户对象放在Session

			//model.addAttribute("user", user);
			sessionProvider.setAttribute(request, Constants.PERSON_SESSION, user);
			JSONObject jo = new JSONObject();
			int code=200;
			jo.put("code",code);
			jo.put("message", "登录成功");
			jo.put("result", true);
			ResponseUtils.renderJson(response, jo.toString());
			}else{
				JSONObject jo = new JSONObject();
				int code=404;
				jo.put("code",code);
				jo.put("message", "密码错误");
				jo.put("result", false);
				ResponseUtils.renderJson(response, jo.toString());
			}
		

	}*/
	
	
}
