package com.bit2017.jblog.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.bit2017.jblog.repository.*;
import com.bit2017.jblog.vo.*;

@Service
public class UserService {

	@Autowired
	UserDao dao;
	
	public void joinUser(UserVo vo) {
		dao.joinUser(vo);
	}
	
	public boolean checkUserId(String id) {
		boolean userId = dao.checkUserId(id);
		return userId;
	}
	
	public UserVo getUserInfo(UserVo vo) {
		UserVo userInfo = dao.getUserInfo(vo);
		return userInfo;
	}
	
	
}
