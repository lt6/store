package com.lt.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CommonController {
	@RequestMapping(value = "/login.do")
	public String login(){
		return "index";
	}
}
