<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 
 @ 날짜 : 2020.07.09
 @ author : 이다은
 -->

<!DOCTYPE html>

<c:set var="root" value="${pageContext.request.contextPath}" />

<html>
<head>
	<meta charset="UTF-8">
	<title>파일 게시판 글쓰기</title>
	<link rel="stylesheet" href="../CSS/board/write.css">	
</head>

<body>
	<div id="board">

		<div id="list">
			<a href="${root}/fileBoard/list.do?pageNumber=${pageNumber}">글목록</a>
		</div>

		<form action="${root}/fileBoard/writeOk.do" method="post" enctype="multipart/form-data">
		
			<input type="hidden" name="pageNumber" value="${pageNumber}" />
			
			<input type="hidden" name="boardNum" value="${boardNum}" />
			<input type="hidden" name="groupNum" value="${groupNum}" />
			<input type="hidden" name="sequenceNum" value="${sequenceNum}" />
			<input type="hidden" name="sequenceLev" value="${sequenceLev}" />

			<div id="createform">
			
				<div class="tuple">
					<label class="index">작성자</label>
					<input class="small" type="text" name="writer" />
				</div>
	
				<div class="tuple">
					<label class="index">제목</label>
					<input class="medium" type="text" name="title" />
				</div>
	
				<div class="tuple">
					<label class="index">이메일</label>
					<input class="medium" type="text" name="email" />
				</div>
	
				<div class="content">
					<label class="index">내용</label>
					<textarea class="large" name="content"></textarea>
				</div>
	
				<div class="tuple">
					<label class="index">비밀번호</label>
					<input class="small" type="password" name="password" />
				</div>
				
				<div class="tuple">
					<label class="index">파일명</label>
					<input class="medium" type="file" name="file" />
				</div>
				
			</div>
			
			<div class="foot">
				<input type="submit" value="글쓰기" />
				<input type="reset" value="다시작성" />
				<input type="button" value="목록보기" onclick="location.href='${root}/fileBoard/list.do?pageNumber=${pageNumber}'" />
			</div>

		</form>
	</div>
	
</body>
</html>