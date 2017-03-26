package com.lt.core.controller;

import java.util.List;

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
public class BuyerController {
	@Autowired
	private ProductService productService;
	@Autowired
	private SessionProvider sessionProvider;
	
	//账务页
	@RequestMapping(value = "/account.do")
	public String show(HttpServletRequest request,ModelMap model){
		if(sessionProvider.getAttribute(request, Constants.PERSON_SESSION)!=null){
			User user = (User) sessionProvider.getAttribute(request, Constants.PERSON_SESSION);
			model.addAttribute("user", user);
			List<Product> buyList=productService.getBuyList();
			model.put("buyList", buyList);
			return "account";
		}else{
			return "login";
		}

	}

		//去购物车
		@RequestMapping(value = "/settleAccount.do")
		public String settleAccount(HttpServletRequest request,ModelMap model){
			if(sessionProvider.getAttribute(request, Constants.PERSON_SESSION)!=null){
				User user = (User) sessionProvider.getAttribute(request, Constants.PERSON_SESSION);
				model.addAttribute("user", user);
				return "settleAccount";
			}else{
				return "login";
			}

		}
	
}
