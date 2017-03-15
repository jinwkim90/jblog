package com.bit2017.jblog.controller;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import com.bit2017.jblog.service.*;
import com.bit2017.jblog.vo.*;
import com.bit2017.security.*;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Autowired
	BlogService blogService;
	
	@RequestMapping(value={"/main/{userId}", ""})
	public String getBlog(@PathVariable String userId,
			Model model, HttpSession session
			) {
		model.addAttribute("filename", blogService.getFileName(userId));
		List<BlogVo> list = blogService.listCategory(userId);
		model.addAttribute("list",list);
		BlogVo defaultPost = blogService.getDefaultPost(userId);
		model.addAttribute("defaultPost", defaultPost);
		if(defaultPost!=null) {
		List<BlogVo> defaultList = blogService.getDefaultPostList(defaultPost.getPostNo());
		System.out.println(defaultList);
		model.addAttribute("postList", defaultList);
		model.addAttribute("userId", userId);
		String blogTitle = blogService.getBlogTitle(userId);
		session.setAttribute("blogTitle", blogTitle);
		}
		
		return "/blog/blog-main";
	}
	
	@RequestMapping(value="/main/{userId}/{catNo}")
	public String getBlogByCat(@PathVariable String userId,
			@PathVariable String catNo,
			Model model) {
		model.addAttribute("filename", blogService.getFileName(userId));
		List<BlogVo> list = blogService.listCategory(userId);
		model.addAttribute("list",list);
		Long catNumber = Long.parseLong(catNo);
		List<BlogVo> postList = blogService.getPostList(catNumber);
		model.addAttribute("postList",postList);
		BlogVo recentpost = blogService.getPostByMaxVal(catNumber);
		model.addAttribute("recentPost", recentpost);
		model.addAttribute("userId", userId);
		
		return "/blog/blog-main";
	}
	
	@RequestMapping("/main/{userId}/{catNo}/{postNo}")
	public String getBlogByPost(@PathVariable String userId,
			@PathVariable String catNo, @PathVariable String postNo, @ModelAttribute BlogVo vo,
			Model model) {
		model.addAttribute("filename", blogService.getFileName(userId));
		List<BlogVo> list = blogService.listCategory(userId);
		model.addAttribute("list",list);
		Long catNumber = Long.parseLong(catNo);
		Long postNumber = Long.parseLong(postNo);
		List<BlogVo> postList = blogService.getPostList(catNumber);
		model.addAttribute("postList",postList);
		vo.setUserId(userId);
		vo.setPostNo(postNumber);
		vo.setCatNo(catNumber);
		BlogVo onepost = blogService.getClickedPost(vo);
		model.addAttribute("onepost", onepost);
		return "/blog/blog-main";
	}
	
	@Auth
	@RequestMapping("/blogadmin/{userId}")
	public String adminBlog(@PathVariable String userId, Model model, HttpSession session) {
		
		String blogTitle = blogService.getBlogTitle(userId);
		model.addAttribute("blogTitle", blogTitle);
		model.addAttribute("filename", blogService.getFileName(userId));
		return "/blog/blog-admin-basic";
	}
	
	@RequestMapping("/basicchange/{userId}/{filename}")
	public String changeBasicInfo(@RequestParam ("logo-file") MultipartFile file,
			@RequestParam("title") String title, 
			@PathVariable String userId,
			@PathVariable String filename,
			Model model, HttpSession session) {
		
		blogService.changeBaiscInfo(file, title, userId);
		model.addAttribute("blogTitle", title);
		model.addAttribute("filename", blogService.getFileName(userId));
		System.out.println(blogService.getFileName(userId));
		
		return "redirect:/blog/main/{userId}";
	}
	
	@RequestMapping("/writeform/{userId}")
	public String blogwriteform(@PathVariable String userId, Model model) {
		List<BlogVo> catNames = blogService.categoryNames(userId);
		model.addAttribute("category", catNames);
		return "/blog/blog-admin-write";
	}
	
	@RequestMapping("/write/{userId}")
	public String blogwrite(@ModelAttribute BlogVo vo, @RequestParam ("categoryoption") String catName, @PathVariable String userId) {
		vo.setCatName(catName);
		vo.setUserId(userId);
		String catNo = blogService.getCatNo(vo);
		//System.out.println("vo : " + vo  + " no : " + catNo);
		Long no = Long.parseLong(catNo);
		
		blogService.insertPost(vo, no);
		
		return "redirect:/blog/main/{userId}";
	}
	
	@RequestMapping("/category/{userId}")
	public String cateogry(@PathVariable String userId, @ModelAttribute BlogVo vo, Model model){
		List<BlogVo> list = blogService.listCategory(userId);
		//System.out.println(list);
		model.addAttribute("list",list);
		//System.out.println(list);
		return "/blog/blog-admin-category";
	}
	
	@RequestMapping("/categoryadd/{userId}")
	public String categoryadd(@ModelAttribute BlogVo vo) {
		//System.out.println(vo);
		blogService.addcategory(vo);
		
		return "redirect:/blog/category/{userId}";
	}
	
	@RequestMapping("/delete/{catNo}/{userId}")
	public String deleteCategory(@PathVariable String catNo, @PathVariable String userId) {
		Long categoryNum = Long.parseLong(catNo);
		blogService.removeCategory(categoryNum);
		return "redirect:/blog/category/{userId}";
	}
	
}
