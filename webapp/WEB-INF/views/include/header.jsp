<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="center-content">
	<ul class="menu">
			<c:choose>
			<c:when test="${empty authUser }">
			<li><a href="${pageContext.request.contextPath }/user/loginform">로그인</a></li>
			<li><a href="${pageContext.request.contextPath }/user/joinform">회원가입</a></li>
			</c:when>
			<c:otherwise>
			<li><a href="${pageContext.request.contextPath }/user/logout">로그아웃</a></li>
			<li><a href="${pageContext.request.contextPath }/blog/main/${authUser.userId}">내블로그</a></li>
			</c:otherwise>
			</c:choose>
		</ul>
	</div>
</body>
</html>