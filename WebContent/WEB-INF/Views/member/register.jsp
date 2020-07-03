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
	<title>회원가입 페이지</title>
	<link rel="stylesheet" href="../CSS/member/register.css">
	<script type="text/javascript" src="${root}/Javascript/member/register.js"></script>
</head>

<body>

	<jsp:include page="../../../index.jsp"/>
	<br/><br/>

	<div id="sign">
		<div>
			<h5>
				회원가입(*필수입력사항입니다.)
			</h5>
		</div>

		<div class="createform">

			<form name="createForm" action="${root}/member/registerOk.do" method="post" onsubmit="return createFormCheck(this);">
			
				<!-- 아이디 -->
				<div class="tuple">
					<label class="index">아이디</label>
					<span class="one">*
						<input class="content" type="text" name="id" />
						<input type="button" onclick="idCheck(createForm, '${root}')" value="아이디 중복 확인" />
					</span>
				</div>
				
				<!-- 비밀번호 -->
				<div class="tuple">
					<label class="index">비밀번호</label>
					<span class="one"> *
						<input class="content" type="password" name="password" />
					</span>
				</div>
				
				<!-- 비밀번호 확인 -->
				<div class="tuple">
					<label class="index">비밀번호확인</label>
					<span class="one"> *
						<input class="content" type="password" name="passwordCheck" />
					</span>
				</div>
				
				<!-- 이름 -->
				<div class="tuple">
					<label class="index">이름</label>
					<span class="one"> *
						<input class="content" type="text" name="name" />
					</span>
				</div>
				
				<!-- 주민번호 -->
				<div class="tuple">
					<label class="index">주민번호</label>
					<span class="one"> *
						<input class="jumin" type="text" name="jumin1" />-
						<input class="jumin" type="text" name="jumin2" />
					</span>
				</div>
				
				<!-- 이메일 -->
				<div class="tuple">
					<label class="index">이메일</label>
					<input class="email" type="text" name="email" />
				</div>
				
				<!-- 우편 번호 -->
				<div class="tuple">
					<label class="index">우편번호</label>
					<span class="one">
						<input class="content" type="text" name="zipcode" />
						<input type="button" onclick="zipcodeSearch('${root}')" value="우편번호검색" />
					</span>
				</div>
				
				<!-- 주소 -->
				<div class="tuple">
					<label class="index">주소</label>
					<input class="address" type="text" name="address" />
				</div>
				
				<!-- 직업 -->
				<div class="tuple">
					<label class="index">직업</label>
					<select class="job" name="job">
						<option value="default">== 직업선택 ==</option>
						<option value="무직">무직</option>
						<option value="학생">학생</option>
						<option value="프로그래머">프로그래머</option>
						<option value="의사">의사</option>						
					</select>
				</div>
				
				<!-- 메일 수신 -->
				<div class="tuple">
					<label class="index">메일수신</label>
					<input class="content" type="radio" name="mailing" value="yes" />yes
					<input class="content" type="radio" name="mailing" value="no" />no
				</div>
				
				<!-- 관심 분야 -->
				<div class="tuple">
					<label class="index">관심분야</label>
					<input class="content" type="checkbox" name="interest" value="경제"/>경제
					<input class="content" type="checkbox" name="interest" value="IT"/>IT
					<input class="content" type="checkbox" name="interest" value="음악"/>음악
					<input class="content" type="checkbox" name="interest" value="미술"/>미술
					<input type="hidden" name="resultInterest" >
				</div>
				
				<!-- 버튼 -->
				<div class="foot">
					<input type="submit" value="가입" />
					<input type="reset" value="취소" />
				</div>

			</form>
		</div>
	</div>

</body>

</html>