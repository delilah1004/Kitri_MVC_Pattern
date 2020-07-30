<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 
 @ 날짜 : 2020.07.02 ~ 03
 @ author : 이다은
 -->

<!DOCTYPE html>

<c:set var="root" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<meta charset="UTF-8">
	<title>우편번호 검색</title>
	<link rel="stylesheet" href="../CSS/member/zipcode.css">
	<script type="text/javascript" src="${root}/Javascript/member/register.js"></script>
</head>
<body>

	<div align="center">
	
		<h3>우편번호를 검색하세요.</h3>
		
		<form action="${root}/member/zipcode.do" method="get">
			<input type="text" name="dong"> 
			<input type="submit" value="검색">
		</form>
		
	</div>
	
	<div align="center">
	
		<c:choose>
			<c:when test="${zipcodeList.size()==0}">
			
				<h3>검색된 결과가 없습니다.</h3>
			
			</c:when>
			
			<c:when test="${zipcodeList.size()>0}">
			
				<h3>아래 우편 번호를 클릭하세요.</h3>
				
				<c:forEach var="zipcodeDto" items="${zipcodeList}">
				
					<div id="address" align="left">
						<a href = "javascript:sendZipcode('${zipcodeDto.zipcode}', '${zipcodeDto.sido}', '${zipcodeDto.gugun}', '${zipcodeDto.dong}', '${zipcodeDto.ri}', '${zipcodeDto.bunji}')">
							<span>${zipcodeDto.zipcode}</span>
							<span>${zipcodeDto.sido}</span>
							<span>${zipcodeDto.gugun}</span>
							<span>${zipcodeDto.dong}</span>
							<span>${zipcodeDto.ri}</span>
							<span>${zipcodeDto.bunji}</span>
						</a>
					</div>
				
				</c:forEach>
			
			</c:when>
			
		</c:choose>
		
	</div>
	
	<div align="center">
		<a href="javascript:self.close()">닫기</a>
	</div>
	
</body>
</html>