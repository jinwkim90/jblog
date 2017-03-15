package com.bit2017.jblog.controller;

import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import com.bit2017.jblog.dto.*;
import com.bit2017.jblog.service.*;
import com.bit2017.jblog.vo.*;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/joinform")
	public String joinform(@ModelAttribute UserVo vo) {
	
		return "/user/join";
	}
	
	@RequestMapping("/join")
	public String join(@ModelAttribute @Valid UserVo userVo, BindingResult result, Model model) {
		
		if(result.hasErrors()==true) {
			model.addAllAttributes(result.getModel());
			return "/user/joinform";
		}
		System.out.println(userVo);
		userService.joinUser(userVo);
		return "/user/joinsuccess";
	}
	
	@ResponseBody
	@RequestMapping("/checkid")
	public JSONResult checkId(
			@RequestParam ("userId") String userId) {
		//System.out.println(userId);
		boolean doesExist = userService.checkUserId(userId);
		//System.out.println(doesExist);
		
		return JSONResult.success(doesExist? "Exist" : "Not exsits");
	}
	
	@RequestMapping("/loginform")
	public String login() {
		return "/user/login";
	}
	
	
}
