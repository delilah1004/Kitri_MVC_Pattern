<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 
 @ 날짜 : 2020.07.02
 @ author : 이다은
 -->

<!DOCTYPE html>

<c:set var="root" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 체크 페이지</title>
</head>
<body>

	<c:if test="${check!=0}">
		<div align="center">
			이미 사용 중인 아이디입니다.
			<form action="${root}/member/idCheck.do" method="get">
				<input type="text" name="id"> 
				<input type="submit" value="확인">
			</form>
		</div>
	</c:if>

	<c:if test="${check ==0}">
		<div align="center">사용 가능한 아이디입니다.</div>
		<script type="text/javascript">opener.createForm.id.value="${id}"</script>
	</c:if>

	<div align="center">
		<a href="javascript:self.close()">닫기</a>
	</div>

</body>
</html>