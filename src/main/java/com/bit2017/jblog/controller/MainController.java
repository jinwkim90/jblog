package com.bit2017.jblog.controller;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.bit2017.jblog.service.*;

@Controller
public class MainController {
	
	//@Autowired
	//private UserService userService;
	
	@RequestMapping("/main")
	public String index() {
		return "/main/index";
	}
	
	
}
