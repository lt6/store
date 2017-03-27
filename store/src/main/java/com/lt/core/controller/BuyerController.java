package com.lt.core.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;








import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.lt.common.Constants;
import com.lt.common.ResponseUtils;
import com.lt.common.session.SessionProvider;
import com.lt.core.bean.Product;
import com.lt.core.bean.User;
import com.lt.core.service.product.ProductService;


@Controller
public class BuyerController extends HttpServlet{
	@Autowired
	private ProductService productService;
	@Autowired
	private SessionProvider sessionProvider;
	
	//账务页
	@RequestMapping(value = "/account.do")
	public String show(HttpServletRequest request,ModelMap model){
		User user = (User) sessionProvider.getAttribute(request, Constants.UER_SESSION);
		if(user!=null && user.getUserType()==0){
			model.addAttribute("user", user);
			List<Product> buyList=productService.getBuyList();
			model.put("buyList", buyList);
			return "account";
		}else{
			return "login";
		}

	}

		//购物车页面
		@RequestMapping(value = "/settleAccount.do")
		public String settleAccount(HttpServletRequest request,ModelMap model){
			User user = (User) sessionProvider.getAttribute(request, Constants.UER_SESSION);
			if(user!=null && user.getUserType()==0){
				model.addAttribute("user", user);
				return "settleAccount";
			}else{
				return "login";
			}

		}
		//购买
		@RequestMapping(value = "/api/buy.do", method = {RequestMethod.POST })
		@ResponseBody
		public String buy(@RequestBody String buyList,HttpServletRequest request,HttpServletResponse response,ModelMap model) {
		User user = (User) sessionProvider.getAttribute(request, Constants.UER_SESSION);
		if(user!=null && user.getUserType()==0){
			model.addAttribute("user", user);
			List<Product> pro_list = new ArrayList<Product>(JSONArray.parseArray(buyList, Product.class));
			for(Product p : pro_list){
				Product product=new Product();
				product.setId(p.getId());
				product.setIsBuy(true);
				product.setIsSell(true);
				product.setBuyNum(p.getNumber());
				product.setSaleNum(p.getNumber());
				product.setBuyTime(new Date());
				productService.buyProduct(product);
			} 
					JSONObject jo = new JSONObject();
					int code=200;
					jo.put("code",code);
					jo.put("message", "购买成功");
					jo.put("result", true);
					ResponseUtils.renderJson(response, jo.toString());
					return null;
			}else{
				return "login";
			}			
		}
	
}
