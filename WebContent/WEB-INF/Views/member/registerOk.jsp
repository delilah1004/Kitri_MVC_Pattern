<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 
 @ 날짜 : 2020.07.02
 @ author : 이다은
 -->

<!DOCTYPE html>

<c:set var="root" value="${pageContext.request.contextPath}"/>

<html>
<head>
<meta charset="UTF-8">
<title>회원가입 확인 페이지</title>
</head>
<body>

	${check}

	<c:if test = "${check > 0}">
		<script type = "text/javascript">
			alert("회원가입이 완료되었습니다.");
			location.href = "${root}/member/register.do";
		</script>
	</c:if>
	
	<c:if test = "${check == 0}">
		<script type = "text/javascript">
			alert("회원가입에 실패하였습니다.");
			location.href = "${root}/member/register.do";
		</script>
	</c:if>
	
</body>
</html>