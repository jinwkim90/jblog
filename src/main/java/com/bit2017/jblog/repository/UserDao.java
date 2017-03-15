package com.bit2017.jblog.repository;

import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.bit2017.jblog.vo.*;

import oracle.jdbc.pool.*;

@Repository
public class UserDao {
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	private OracleDataSource dataSource;
	
	
	public boolean joinUser(UserVo vo ) {
		
		int join = sqlSession.insert("users.insertuser", vo);
		sqlSession.insert("users.insertblogdefault", vo);
		sqlSession.insert("users.insertcatdefault", vo);
		
		return join==1;
		
	}
	
	public boolean checkUserId(String id) {
		
		String userId = sqlSession.selectOne("users.selectuser", id);
		return id.equals(userId);
	}
	
	public UserVo getUserInfo(UserVo vo) {
		UserVo userInfo = sqlSession.selectOne("users.finduserinfo", vo);
		return userInfo;
	}
	
	
}
