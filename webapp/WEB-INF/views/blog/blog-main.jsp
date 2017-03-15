<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/include/blog-header.jsp" />
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<c:if test="${recentPost.postTitle !=''||recentPost.postTitle ne null}">
					<h4>${recentPost.postTitle }</h4>
					<p>
						${recentPost.postContent }
					<p>
					</c:if>
					<h4>${defaultPost.postTitle }</h4>
					<p>
						${defaultPost.postContent }
					<p>
					<h4>${onepost.postTitle }</h4>
					<p>
						${onepost.postContent }
					<p>
				</div>
				<ul class="blog-list">
				<%-- <c:if test="${recentPost.postTitle !=''||recentPost.postTitle ne null}"> --%>
				 <c:forEach  var="post" items="${postList }" > 
					<li><a href="${pageContext.request.contextPath }/blog/main/${userId}/${post.catNo}/${post.postNo}">${post.postTitle }</a> <span>${post.postPubDate } </span>	</li>
				</c:forEach> 
				<%-- </c:if> --%>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}/blog/${filename}">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:forEach items="${list }" var="category">
				<li><a href="${pageContext.request.contextPath }/blog/main/${userId}/${category.catNo}">${category.catName }</a></li>
				</c:forEach>
			</ul>
		</div>
		
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>