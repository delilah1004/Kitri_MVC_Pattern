<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 
 @ 날짜 : 2020.07.01 ~ 03
 @ author : 이다은
 -->

<!DOCTYPE html>

<!-- 루트 경로 가져오기 (프로젝트명) -->
<c:set var="root" value="${pageContext.request.contextPath}" />

<html>
<head>
	<meta charset="UTF-8">
	<title>MVC HomePage</title>
</head>
<body>

	<div align="right">
		
		<c:if test="${memberLevel==null}">
			<a href="${root}/member/register.do">회원가입</a>
			<a href="${root}/member/login.do">로그인</a>
		</c:if>

		<c:if test="${memberLevel!=null}">
			<a href="">회원수정</a>
			<a href="">회원탈퇴</a>
			<a href="${root}/member/logout.do">로그아웃</a>
		</c:if>
		
	</div>

</body>
</html>