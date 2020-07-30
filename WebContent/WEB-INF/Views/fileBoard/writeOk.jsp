<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 
 @ 날짜 : 2020.07.09
 @ author : 이다은
 -->

<!DOCTYPE html>

<c:set var="root" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<meta charset="UTF-8">
	<title>파일 게시판 글쓰기 확인</title>
</head>
<body>

	${check}

	<c:if test = "${check > 0}">
		<script type = "text/javascript">
			alert("글쓰기가 완료되었습니다.");
			location.href = "${root}/fileBoard/list.do?pageNumber=" + ${pageNumber};
		</script>
	</c:if>
	
	<c:if test = "${check == 0}">
		<script type = "text/javascript">
			alert("글쓰기에 실패하였습니다.");
			location.href = "${root}/fileBoard/write.do?pageNumber=" + ${pageNumber};
		</script>
	</c:if>
	
</body>
</html>