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
	<title>로그아웃</title>
	<link rel="stylesheet" href="../CSS/member/login.css">
	<script type="text/javascript" src="${root}/Javascript/member/login.js"></script>
</head>
<body>
	
	<jsp:include page="../../../index.jsp"/>
	<br/><br/>
	
	<c:remove var="id" scope="session"/>
	<c:remove var="name" scope="session"/>
	<c:remove var="memberLevel" scope="session"/>
	
	<script type="text/javascript">
		alert("로그아웃되었습니다.");
		location.href="${root}/member/login.do"
	</script>

</body>
</html>