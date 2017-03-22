package com.lt.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lt.core.bean.Content;
import com.lt.core.service.content.ContentService;


@Controller
public class SellerController {
	@Autowired
	private ContentService contentService;
	
	//发布内容
	@RequestMapping(value = "/addContent.do")
	public String add(Content content,ModelMap model){
		int x=contentService.addContent(content);
		model.addAttribute("x",x);
		return "publicSubmit";
	}
	
	//跳转发布页面
	@RequestMapping(value= "/toAddContent.do")
	public String toAdd(){
		return "public";
	}
}
