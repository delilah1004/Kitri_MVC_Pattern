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
	<title>파일 게시판 글 삭제</title>
	<link rel="stylesheet" href="../CSS/board/delete.css">
	
</head>

<body>

	<div id="board">

		<div class="num">
			<label>글 번호 : ${dto.boardNum}</label>
		</div>

		<div class="count">
			<label>조회수 : ${dto.readCnt}</label>
		</div>

		<form action="${root}/fileBoard/deleteOk.do" method="post">
		
			<input type="hidden" name="boardNum" value="${dto.boardNum}" />
			<input type="hidden" name="pageNumber" value="${pageNumber}" />

			<div id="createform">

				<div class="tuple">
					<label class="index">작성자</label> 
					<label class="content">${dto.writer}</label>
				</div>

				<div class="tuple">
					<label class="index">제목</label> 
					<label class="content">${dto.title}</label>
				</div>

				<div class="tuple">
					<label class="index">작성일</label> 
					<label class="content">
						<fmt:formatDate value="${dto.writeDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</label>
				</div>

				<div class="content">
					<label class="index">내용</label>
					<label class="content">${dto.content}</label>
				</div>
				
			</div>

			<div id="foot">
				<div class="password">
					<label class="content">비밀번호 확인  </label>
					<input type="password" name="password">
					<input type="submit" value="삭제하기"/>
				</div>
				<div class="button">
					<a href="${root}/fileBoard/list.do?pageNumber=${pageNumber}">글목록</a>
				</div>
			</div>

		</form>
		
	</div>

</body>

</html>