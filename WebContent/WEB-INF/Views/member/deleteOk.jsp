<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 
 @ 날짜 : 2020.07.06
 @ author : 이다은
 -->

<!DOCTYPE html>

<c:set var="root" value="${pageContext.request.contextPath}" />

<html>
<head>
	<meta charset="UTF-8">
	<title>회원 탈퇴 확인</title>
</head>
<body>

	${check}

	<c:if test="${check > 0}">
		
		<c:remove var="id" scope="session"/>
		<c:remove var="name" scope="session"/>
		<c:remove var="memberLevel" scope="session"/>
	
		<script type="text/javascript">
			alert("회원 탈퇴 완료");
			location.href = "${root}/member/login.do";
		</script>
		
	</c:if>

	<c:if test="${check == 0}">
		<script type="text/javascript">
			alert("회원 탈퇴 실패");
			location.href = "${root}/member/delete.do";
		</script>
	</c:if>

</body>
</html>