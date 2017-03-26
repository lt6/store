package com.lt.core.controller;

import java.util.List;

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
import com.lt.core.bean.Product;
import com.lt.core.bean.User;
import com.lt.core.service.product.ProductService;
import com.lt.core.service.user.UserService;
import com.lt.web.Constants;



@Controller
public class CommonController extends HttpServlet{
	
	@Autowired
	private SessionProvider sessionProvider;
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	
	//去首页
	@RequestMapping(value = "/index.do")
	public String index(HttpServletRequest request,ModelMap model){
		//加载用户
		if(sessionProvider.getAttribute(request, Constants.PERSON_SESSION)!=null){
			User user = (User) sessionProvider.getAttribute(request, Constants.PERSON_SESSION);
/*			Integer type=user.getUserType();
			System.out.println(user.getUserType());
			model.addAttribute("type", type);*/
			model.addAttribute("user", user);
			List<Product> productList=productService.getProductList();
			model.put("productList", productList);
			return "index";
		}else{
			List<Product> productList=productService.getProductList();
			model.put("productList", productList);
			return "index";
		}

	}
	//去登录页
	@RequestMapping(value = "/login.do")
	public String login(){
		return "login";
	}
	
	
	//去查看页
	@RequestMapping(value = "/show.do")
	public String show(HttpServletRequest request,Integer id,ModelMap model){
		if(sessionProvider.getAttribute(request, Constants.PERSON_SESSION)!=null){
			User user = (User) sessionProvider.getAttribute(request, Constants.PERSON_SESSION);
			System.out.println(user.getUserType());
			model.addAttribute("user", user);
			Product product=productService.show(id);
			model.addAttribute("product", product);
			return "show";
		}else{
			Product product=productService.show(id);
			model.addAttribute("product", product);
			return "show";
		}

	}
	//确认登录
	@RequestMapping(value = "/api/login.do")
	public void login (HttpServletRequest request,HttpServletResponse response,ModelMap model){
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			System.out.println(userName);
			User user=userService.getUserByUsername(userName);
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

	}
	//退出登录
	@RequestMapping(value = "/logout.do")
	public String logout(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		User user = (User) sessionProvider.getAttribute(request, Constants.PERSON_SESSION);
		sessionProvider.logout(request, response);
		return "redirect:/login.do";
	}
	
	
}
