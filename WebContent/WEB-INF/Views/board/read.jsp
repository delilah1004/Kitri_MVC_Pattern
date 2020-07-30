<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 
 @ 날짜 : 2020.07.08
 @ author : 이다은
 -->

<!DOCTYPE html>

<c:set var="root" value="${pageContext.request.contextPath}" />

<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 글 읽기</title>
	<link rel="stylesheet" href="../CSS/board/read.css">
	
	<script type="text/javascript">
		function replyFun(root, boardNum, groupNum, sequenceNum, sequenceLev, pageNumber){
			var url = root + "/board/write.do?boardNum=" + boardNum;
			url += "&groupNum=" + groupNum;
			url += "&sequenceNum=" + sequenceNum;
			url += "&sequenceLev=" + sequenceLev;
			url += "&pageNumber=" + pageNumber;
			
			location.href = url;
		}
		
		function delFun(root, boardNum, pageNumber) {
			var url = root + "/board/delete.do?boardNum=" + boardNum;
			url += "&pageNumber=" + pageNumber;
			//alert(url);
			location.href = url;
			
			/*
			var value = confirm("삭제하시겠습니까?");
			if(value==true){
				var url = root + "/board/deleteOk.do?boardNum=" + boardNum + "&pageNumber=" + pageNumber;
				location.href = url;
			} else {
				alert("삭제가 취소되었습니다.");
			}
			*/
		}
		
		function updateFun(root, boardNum, pageNumber) {
			var url = root + "/board/update.do?boardNum=" + boardNum;
			url += "&pageNumber=" + pageNumber;
			// alert(url);
			location.href = url;
		}
	</script>
	
</head>

<body>

	<div id="board">

		<div class="num">
			<label>글 번호 : ${dto.boardNum}</label>
		</div>

		<div class="count">
			<label>조회수 : ${dto.readCnt}</label>
		</div>

		<form action="${root}/board/writeOk.do" method="post">
		
			<input type="hidden" name="readCnt" value="${readCnt}" />
			<input type="hidden" name="writer" value="${writer}" />
			<input type="hidden" name="sequenceNum" value="${sequenceNum}" />
			<input type="hidden" name="sequenceLev" value="${sequenceLev}" />

			<div id="createform">
			
				<div class="tuple">
					<label class="index">제목</label> 
					<label class="content">${dto.title}</label>
				</div>

				<div class="tuple">
					<label class="index">작성자</label> 
					<label class="content">${dto.writer}</label>
				</div>
				
				<div class="tuple">
					<label class="index">이메일</label> 
					<label class="content">${dto.email}</label>
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

			<div class="foot">
				<input type="button" value="글수정"
					onclick="updateFun('${root}','${dto.boardNum}','${pageNumber}')" />
				<input type="button" value="글삭제"
					onclick="delFun('${root}','${dto.boardNum}','${pageNumber}')" />
				<input type="button" value="답글"
					onclick="replyFun('${root}','${dto.boardNum}','${dto.groupNum}','${dto.sequenceNum}','${dto.sequenceLev}', '${pageNumber}')" />
				<input type="button" value="목록보기"
					onclick="location.href='${root}/board/list.do?pageNumber=${pageNumber}'" />
			</div>
			
		</form>
		
	</div>

</body>

</html>