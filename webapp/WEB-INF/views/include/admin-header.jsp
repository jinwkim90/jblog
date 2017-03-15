<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<ul class="admin-menu">
	<li><a href="${pageContext.request.contextPath}/blog/blogadmin/${authUser.userId}">기본설정</a></li>
	<li><a href="${pageContext.request.contextPath}/blog/category/${authUser.userId}">카테고리</a></li>
	<li><a href="${pageContext.request.contextPath}/blog/writeform/${authUser.userId}">글작성</a></li>
</ul>