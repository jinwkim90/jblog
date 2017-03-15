package com.bit2017.jblog.repository;

import java.util.*;

import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.bit2017.jblog.vo.*;

@Repository
public class BlogDao {

	@Autowired
	SqlSession sqlSession;
	
	public boolean changeBoardBasic(BlogVo vo) {
		//System.out.println("나오니이이이이:" + vo);
		int insert = sqlSession.update("blog.insertblogbasic",vo);
		return insert==1;
	}
	
	public String getFileName(String userId) {
		String filename = sqlSession.selectOne("blog.selectfilename", userId);
		return filename;
	}
	
	public boolean insertCategory(BlogVo vo) {
		int insert = sqlSession.insert("blog.insertcategory", vo);
		return insert==1;
	}
	
	public List<BlogVo> showCategory(String userId) {
		return sqlSession.selectList("blog.selectcategory", userId);
	}
	
	public List<BlogVo> showCategoryName(String userId) {
		//System.out.println(sqlSession.selectList("blog.selectcategoryName", userId));
		return sqlSession.selectList("blog.selectcategoryName", userId);
	}
	
	public boolean insertPost(BlogVo vo, Long catNo){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("catNo", catNo);
		map.put("postTitle", vo.getPostTitle());
		map.put("postContent", vo.getPostContent());
		
		int insertPost =  sqlSession.insert("blog.insertpost", map);
		return insertPost==1;
	}
	
	public String getCatNo(BlogVo vo) {
		return sqlSession.selectOne("blog.selectcategoryNo", vo);
	}
	
	public List<BlogVo> getPostList(Long catNo) {
		return sqlSession.selectList("blog.selectpost", catNo);
	}
	
	public BlogVo getPostByMaxCatNo(Long catNo) {
		return sqlSession.selectOne("blog.selectpostbymaxval", catNo);
	}
	
	public BlogVo getDefaultPost(String userId) {
		return sqlSession.selectOne("blog.selectdefaultpost", userId);
	}
	
	public List<BlogVo> getDefaultPostList(Long postNo) {
		return sqlSession.selectList("blog.selectdefaultpostlist", postNo);
	}
	
	public String getBlogTitle(String userId) {
		return sqlSession.selectOne("blog.selectblogtitle", userId);
	}
	
	public boolean deleteCategory(Long catNo) {
		int delete = sqlSession.delete("blog.deletecategory", catNo);
		return delete==1;
	}
	
	public BlogVo getPost (BlogVo vo) {
		return sqlSession.selectOne("blog.selectonepost", vo);
	}
	
}
