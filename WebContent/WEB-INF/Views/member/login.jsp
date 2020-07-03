<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 
 @ 날짜 : 2020.07.03
 @ author : 이다은
 -->

<!DOCTYPE html>

<c:set var="root" value="${pageContext.request.contextPath}" />

<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<link rel="stylesheet" href="../CSS/member/login.css">
	<script type="text/javascript" src="${root}/Javascript/member/login.js"></script>
</head>
<body>
	
	<jsp:include page="../../../index.jsp"/>
	<br/><br/>
	
	<div id="main" align="center">

		<form action="${root}/member/loginOk.do" method="post" onsubmit="return idCheck(this)">

			<h3>로그인</h3>

			<div id="tuple" align="right">
				아이디 : <input type="text" name="id" />
			</div>

			<div id="tuple" align="right">
				비밀번호 : <input type="password" name="password" />
			</div>

			<input type="submit" value="로그인" /> <input type="reset" value="취소" />
			
		</form>

	</div>

</body>
</html>