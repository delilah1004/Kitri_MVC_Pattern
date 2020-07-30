<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 
 @ 날짜 : 2020.07.09
 @ author : 이다은
 -->
    
<!DOCTYPE html>

<c:set var="root" value="${pageContext.request.contextPath}" />

<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 글 수정</title>
	<link rel="stylesheet" href="../CSS/board/update.css">
</head>
<body>
	<div id="board">

		<div id="list">
			<a href="${root}/board/list.do?pageNumber=${pageNumber}">글목록</a>
		</div>

		<form action="${root}/board/updateOk.do" method="post">
		
			<input type="hidden" name="pageNumber" value="${pageNumber}" />
			<input type="hidden" name="boardNum" value="${dto.boardNum}" />

			<div id="createform">
			
				<div class="tuple">
					<label class="index">작성자</label>
					<input class="small" type="text" name="writer" value="${dto.writer}" />
				</div>
	
				<div class="tuple">
					<label class="index">제목</label>
					<input class="medium" type="text" name="title" value="${dto.title}" />
				</div>
	
				<div class="tuple">
					<label class="index">이메일</label>
					<input class="medium" type="text" name="email" value="${dto.email}" />
				</div>
	
				<div class="content">
					<label class="index">내용</label>
					<textarea class="large" name="content">${dto.content}</textarea>
				</div>
	
				<div class="tuple">
					<label class="index">비밀번호</label>
					<input class="small" type="password" name="password" />
				</div>
				
			</div>

			<div class="foot">
				<input type="submit" value="수정하기" />
				<input type="reset" value="다시작성" />
			</div>

		</form>
	</div>
</body>
</html>