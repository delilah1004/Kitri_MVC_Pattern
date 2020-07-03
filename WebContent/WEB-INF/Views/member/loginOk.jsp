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
<title>로그인 확인 페이지</title>
</head>
<body>

	${check}

	<c:if test="${memberLevel != null}">
		
		<c:set var="id" value="${id}" scope="session"/>
		<c:set var="name" value="${name}" scope="session"/>
		<c:set var="memberLevel" value="${memberLevel}" scope="session"/>
		
		<script type="text/javascript">
			alert("로그인 성공");
			location.href = "${root}/member/main.do";
		</script>
	</c:if>

	<c:if test="${memberLevel == null}">
		<script type="text/javascript">
			alert("아이디 또는 비밀번호가 일치하지 않습니다. 아이디와 비밀번호를 다시 확인하세요.");
			location.href = "${root}/member/login.do";
		</script>
	</c:if>

</body>
</html>