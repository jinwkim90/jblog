package com.bit2017.security;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.*;
import org.springframework.web.context.support.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.handler.*;

import com.bit2017.jblog.service.*;
import com.bit2017.jblog.vo.*;


public class AuthLoginInterceptor extends HandlerInterceptorAdapter {

	
	//이렇게 바로 가져올 수도 있음
	/*@Autowired
	private UserService userService;*/
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		UserVo vo = new UserVo();
		vo.setUserId(userId);
		vo.setPassword(password);
		
		
		
		
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());		
		
		UserService userService = ac.getBean(UserService.class);
		UserVo userInfo = userService.getUserInfo(vo);
		//System.out.println(vo);
		if(userInfo==null) {
			response.sendRedirect(request.getContextPath() +"/user/loginform?result=fail");
			return false;
		}
		
		//인증처리
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", userInfo);
		
		response.sendRedirect(request.getContextPath() + "/main");
		
		System.out.println(session.getAttribute("authUser"));
		return false;
	}

}
