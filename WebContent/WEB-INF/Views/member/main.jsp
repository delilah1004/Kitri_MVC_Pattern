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
	<title>메인 홈페이지</title>
</head>
<body>

	<jsp:include page="../../../index.jsp" />
	<div align="right">${name}님</div>

	<div align="center">

		<h3>메인 홈페이지 입니다.</h3>
		
		<c:if test="${memberLevel==null}">
			<h4>로그인 하세요.</h4>
		</c:if>

		<c:choose>

			<c:when test="${memberLevel!='MA'}">
				<h4>${memberLevel} ${name}님 안녕하세요!</h4>
			</c:when>

			<c:when test="${memberLevel=='MA'}">
				<h4>${memberLevel} ${name} 페이지입니다.</h4>
			</c:when>

		</c:choose>

	</div>

</body>
</html>