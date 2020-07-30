<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>

<c:set var="root" value="${pageContext.request.contextPath}" />

<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 글 수정 확인</title>
</head>
<body>
	${check}
	
	<c:if test="${check > 0}">
		<script type="text/javascript">
			alert("수정이 완료되었습니다.");
			location.href = "${root}/board/list.do?pageNumber=" + ${pageNumber};
		</script>
	</c:if>
	
	<c:if test = "${check == 0}">
		<script type="text/javascript">
			alert("수정에 실패하였습니다.");
			location.href = "${root}/board/update.do?boardNum=" + ${boardNum} + "&pageNumber=" + ${pageNumber};
		</script>
	</c:if>
</body>
</html>