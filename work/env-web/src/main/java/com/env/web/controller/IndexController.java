package com.env.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.env.web.annotation.NeedLogin;

@NeedLogin(false)
@Controller
@RequestMapping()
public class IndexController {

	
	public IndexController() {
	}

    @RequestMapping("/")
	public String index(){
    	System.out.println("IndexController");
		return "index/pages/index";
	}


}
