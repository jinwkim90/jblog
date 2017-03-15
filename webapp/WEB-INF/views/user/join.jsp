<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script
	src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.1/jquery-ui.min.js"></script>
<script>
	$(function() {
		/* $("#join-form").submit(function() {
			
			var id = $("#userId").val();
			if(id=="") {
				alert("아이디가 비어있습니다");
				$("#userId").focus();
				return false;
			}
			var name = $("#name").val();
			if(name=="") {
				alert("이름이 비어있습니다");
				$("#name").focus();
				return false;
			}
			var password = $("#password").val();
			if(password=="") {	
				alert("패스워드가 비어있습니다");
				$("#password").focus();
				return false;
			}
			return true;
		}); */
		
		$("#btn-checkid").click(function() {
			var id = $("#userId").val();
			$.ajax({
				url : "/jblog/user/checkid?userId=" + id,
				type : "get",
				dataType : "json",
				data : "",
				success : function(response) {

					console.log(response);

					if (response.result == "fail") {
						console.log("error" + response.message);
						return;
					}

					if (response.data == "Exist") {
						//alert("존재하는 이메일입니다. 다른 이메일을 사용해주세요");
						$("#dialogMessage").dialog();
						return;
					}
					
					if(id=="") {
						$("#dialogMessage2").dialog();
						$("#userId").focus();
						return;
					}

					//존재하지 않는 경우(사용가능)
					$("#img-checkemail").show();
					$("#btn-checkid").hide();
				},
				error : function(XHR, status, error) {
					console.error(status + " : " + error);
				}
			});
		});
	}); 
	


</script>
</head>
<body>
	<div class="center-content">
		<h1 class="logo">JBlog</h1>
		<c:import url="/WEB-INF/views/include/header.jsp" />
		<form:form modelAttribute="userVo" class="join-form" id="join-form" method="post" action="${pageContext.request.contextPath }/user/join">
			<label class="block-label" for="name">이름</label>
			<form:input path="name" id="name" name="name" type="text" value="" /><form:errors path="name"/>

			<label class="block-label" for="blog-id">아이디</label>
			<form:input id="userId" name="userId" type="text" path="userId"/><form:errors path="userId"/>
			<input id="btn-checkid" type="button" value="id 중복체크">
			<img id="img-checkemail" style="display: none;" src="${pageContext.request.contextPath}/assets/images/check.png">

			<label class="block-label" for="password">패스워드</label>
			<form:input id="password" name="password" type="password" path="password"/><form:errors path="password"/>

			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>

			<input type="submit" value="가입하기">

		</form:form>
	</div>
	<div id="dialogMessage" title="중복된 이메일" style="display: none">
		<p>
			존재하는 이메일 입니다. <br>다른 이메일을 사용해주세요
		</p>
	</div>
	<div id="dialogMessage2" title="비어있는 이메일" style="display: none">
		<p>
			이메일이 비어있습니다. <br>이메일 형식으로 입력뒤 다시 중복체크 부탁드립니다.
		</p>
	</div>
</body>
</html>
