<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!--
 @ 날짜 : 2020.07.07
 @ author : 이다은
 -->

<!DOCTYPE html>

<c:set var="root" value="${pageContext.request.contextPath}" />

<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 글목록</title>
	<link rel="stylesheet" href="../CSS/board/list.css">
</head>
<body>

	<jsp:include page="../../../index.jsp" />

	<div id="content">
	
		<c:if test="${boardCount==0 || array.size()==0}">
		
		<div id="write" >
			<a href="${root}/board/write.do">글쓰기</a>
		</div>
	
		<h3 id="empty">게시판에 저장된 글이 없습니다.</h3>
	
		</c:if>
	
		<c:if test="${boardCount>0}">
		
		<div id="write" >
			<a href="${root}/board/write.do?pageNumber=${pageNumber}">글쓰기</a>
		</div>
	
		<div id="board">
		
			<div class="title">
				<span>번호</span>
				<span>제목</span>
				<span>작성자</span>
				<span>작성일</span>
				<span>조회수</span>
			</div>
		
			<c:forEach var="dto" items="${array}">
			<div class="content">
				<span>${dto.boardNum}</span>
				<span>
					<c:if test="${dto.sequenceLev > 0}">
						<c:forEach begin="0" end="${dto.sequenceLev}">
							&nbsp;&nbsp;
						</c:forEach>
						<b>[답글]</b>
					</c:if>
					
					<a href="${root}/board/read.do?boardNum=${dto.boardNum}&pageNumber=${pageNumber}">${dto.title}</a>
				</span>
				<span>${dto.writer}</span>
				<span>
					<fmt:formatDate value="${dto.writeDate}" pattern="yyyy-MM-dd-HH:mm:ss"/>
				</span>
				<span>${dto.readCnt}</span>
			</div>
			</c:forEach>
			
		</div>
			
		</c:if>
	
		<div id="pageNum">
	
			<!-- 1. 한 페이지당 게시물 수(boardSize) : 10
				 2. 총 페이지수(pageCount) : 10page = 전체 레코드 수 100 / 한 페이지당 게시물 수 10
				 						  11page = 전체 레코드 수 101 / 한 페이지당 게시물 수 10
				 3. 페이지 번호 블럭(pageBlock) : 10
				 							[1][2][3][4][5]...[10]
				 							요청 페이지번호가 5이면, 시작번호 1, 끝번호 10
	
				 							int startPage = (int) ((pageNumber-1)/pageBlock)*pageBlock)+1
				 							int endPage = startPage + pageBlock - 1
	
				 4. boardSize, pageNumber, boardCount : Command Data -->
	
			<!-- pageCount : 총 페이지 수 / pageBlock : 페이지 묶음 단위 -->
			<fmt:parseNumber var="temp" value="${boardCount/boardSize}" integerOnly="true"/>
			<c:set var="pageCount" value="${temp + (boardCount % boardSize == 0 ? 0 : 1)}"/>
			<c:set var="pageBlock" value="${3}"/>
	
			<!-- pageNumber : 현재 페이지 번호 -->
			<fmt:parseNumber var="result" value="${(pageNumber-1)/pageBlock}" integerOnly="true"/>
			<c:set var="startPage" value="${result * pageBlock + 1}"/>
			<c:set var="endPage" value="${startPage + pageBlock -1}"/>
			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}"/>
			</c:if>
			
			<!-- [이전] 표시 조건 -->
			<c:if test="${startPage > pageBlock}">
				<a href="${root}/board/list.do?pageNumber=${startPage-pageBlock}">[이전]</a>
			</c:if>
	
			<!-- 페이지 번호 생성 -->
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a href="${root}/board/list.do?pageNumber=${i}">[${i}]</a>
			</c:forEach>
			
			<!-- [다음] 표시 조건 -->
			<c:if test="${endPage < pageCount}">
				<a href="${root}/board/list.do?pageNumber=${endPage+1}">[다음]</a>
			</c:if>
	
		</div>
	
	</div>

</body>
</html>
