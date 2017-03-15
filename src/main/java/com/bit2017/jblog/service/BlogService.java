package com.bit2017.jblog.service;

import java.io.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.multipart.*;

import com.bit2017.jblog.repository.*;
import com.bit2017.jblog.vo.*;

@Service
public class BlogService {
	
	@Autowired
	BlogDao dao;
	
	private static final String SAVE_PATH = "/upload";
	
	public String getFileName(String userId) {
		return dao.getFileName(userId);
	}
	
	public void changeBaiscInfo(MultipartFile file, String title, String userId) {
		
		if(file.isEmpty()) {
			return;
		}
		
		String originalFileName = file.getOriginalFilename();
		String extName = originalFileName.substring(originalFileName.lastIndexOf(".")+1, originalFileName.length());
		String saveFileName = generateFileName(extName);
		try {
			writeFile(file, saveFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BlogVo vo = new BlogVo();
		vo.setTitle(title);
		vo.setSaveFileName(saveFileName);
		vo.setUserId(userId);
		
		dao.changeBoardBasic(vo);
		
	}
	
	public void writeFile(MultipartFile file, String saveFileName) throws IOException {
		

			byte[] data = file.getBytes();
			FileOutputStream fos = new FileOutputStream(SAVE_PATH+"/"+saveFileName);
			fos.write(data);
			fos.close();
	}
	
	public String generateFileName(String extName) {
		
		String fileName="";
		
		Calendar calendar = Calendar.getInstance();
		fileName+= calendar.get(Calendar.YEAR);
		fileName+= calendar.get(Calendar.MONTH);
		fileName+= calendar.get(Calendar.DATE);
		fileName+= calendar.get(Calendar.HOUR);
		fileName+= calendar.get(Calendar.MINUTE);
		fileName+= calendar.get(Calendar.SECOND);
		fileName+= calendar.get(Calendar.MILLISECOND);
		fileName += ("."+extName);
		
		return fileName;
		
	}
	
	public void addcategory(BlogVo vo) {
		dao.insertCategory(vo);
	}
	
	public List<BlogVo> listCategory(String userId) {
		
		return dao.showCategory(userId);
	}
	
	public List<BlogVo> categoryNames(String userId) {
		//System.out.println("yoooooooooooooo" + dao.showCategoryName(userId));
		return dao.showCategoryName(userId);
	}
	
	public String getCatNo(BlogVo vo) {
		return dao.getCatNo(vo);
	}
	
	public void insertPost(BlogVo vo, Long catNo) {
		dao.insertPost(vo, catNo);
	}
	
	public List<BlogVo> getPostList(Long catNo) {
		return dao.getPostList(catNo);
	}
	
	public BlogVo getPostByMaxVal(Long catNo) {
		return dao.getPostByMaxCatNo(catNo);
	}
	
	public BlogVo getDefaultPost(String userId) {
		return dao.getDefaultPost(userId);
	}
	
	public List<BlogVo> getDefaultPostList(Long postNo) {
		return dao.getDefaultPostList(postNo);
	}
	
	public BlogVo getClickedPost(BlogVo vo ) {
		return dao.getPost(vo);
	}
	
	public String getBlogTitle(String userId) {
		return dao.getBlogTitle(userId);
	}
	
	public void removeCategory(Long catNo) {
		dao.deleteCategory(catNo);
	}
	
	public void deleteLogo(String saveFileName) {
		File file = new File("D:/upload" + saveFileName);
		file.delete();
	}
}
