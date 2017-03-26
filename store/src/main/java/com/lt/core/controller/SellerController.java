package com.lt.core.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lt.common.session.SessionProvider;
import com.lt.core.bean.Product;
import com.lt.core.bean.User;
import com.lt.core.service.product.ProductService;
import com.lt.web.Constants;


@Controller
public class SellerController extends HttpServlet{
	@Autowired
	private ProductService productService;
	@Autowired
	private SessionProvider sessionProvider;
	
	//去发布页
	@RequestMapping(value = "/public.do")
	public String toPublic(HttpServletRequest request,ModelMap model){
		if(sessionProvider.getAttribute(request, Constants.PERSON_SESSION)!=null){
			User user = (User) sessionProvider.getAttribute(request, Constants.PERSON_SESSION);
			model.addAttribute("user", user);
			return "public";
		}else{
			return "login";
		}
	}
	
	/*	//发布内容
	@RequestMapping(value = "/addContent.do")
	public String add(Content content,ModelMap model){
		contentService.addContent(content);
		return "publicSubmit";
	}
	//编辑发布内容
	@RequestMapping(value = "/edit.do")
	public String show(Integer id,ModelMap model){
		Content content=contentService.edit(id);
		model.addAttribute("content", content);
		return "edit";
	}
	//完成编辑
	@RequestMapping(value = "/doEdit.do")
	public String doEdit(Content content){
		return "edit";
	}
	//跳转发布页面
	@RequestMapping(value= "/toAddContent.do")
	public String toAdd(HttpServletRequest request){
		if((Person) sessionProvider.getAttribute(request, Constants.PERSON_SESSION)!=null){
			return "public";
		}else{
			return "login";
		}	
	}*/

}
