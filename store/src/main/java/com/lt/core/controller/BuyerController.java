package com.lt.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lt.core.bean.Product;
import com.lt.core.service.product.ProductService;

@Controller
public class BuyerController {
	@Autowired
	private ProductService productService;
	
	//去查看页
	@RequestMapping(value = "/show.do")
	public String show(Integer id,ModelMap model){
		Product product=productService.show(id);
		model.addAttribute("product", product);
		return "show";
	}
}
