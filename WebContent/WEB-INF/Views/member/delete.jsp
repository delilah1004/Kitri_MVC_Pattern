<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 
 @ 날짜 : 2020.07.06
 @ author : 이다은
 -->

<!DOCTYPE html>

<c:set var="root" value="${pageContext.request.contextPath}"/>

<html>

<head>
	<meta charset="UTF-8">
	<title>회원 탈퇴</title>
	<link rel="stylesheet" href="../CSS/member/update.css">
	<script type="text/javascript" src="${root}/Javascript/member/delete.js"></script>
</head>

<body>

	<jsp:include page="../../../index.jsp"/>
	<br/><br/>

	<div id="sign">
		<div>
			<h5>
				회원탈퇴(*필수입력사항입니다.)
			</h5>
		</div>

		<div class="createform">

			<form name="createForm" action="${root}/member/deleteOk.do" method="post" onsubmit="return createFormCheck(this, '${memberDto.password}');">
			
				<input type="hidden" name = "num" value="${memberDto.num}" />
			
				<!-- 아이디 -->
				<div class="tuple">
					<label class="index">아이디</label>
					<span class="one">*
						<input class="content" type="text" name="id" value="${memberDto.id}" disabled="disabled" />
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
						<input class="content" type="text" name="name" value="${memberDto.name}" disabled="disabled" />
					</span>
				</div>
				
				<!-- 주민번호 -->
				<div class="tuple">
					<label class="index">주민번호</label>
					<span class="one"> *
						<input class="jumin" type="text" name="jumin1" value="${memberDto.jumin1}" disabled="disabled"/>-
						<input class="jumin" type="password" name="jumin2" value="${memberDto.jumin2}" disabled="disabled" />
					</span>
				</div>
				
				<!-- 이메일 -->
				<div class="tuple">
					<label class="index">이메일</label>
					<input class="email" type="text" name="email" value="${memberDto.email}" disabled="disabled" />
				</div>
				
				<!-- 우편 번호 -->
				<div class="tuple">
					<label class="index">우편번호</label>
					<span class="one">
						<input class="content" type="text" name="zipcode" value="${memberDto.zipcode}" disabled="disabled" />
						<input type="button" onclick="zipcodeSearch('${root}')" value="우편번호검색" disabled="disabled" />
					</span>
				</div>
				
				<!-- 주소 -->
				<div class="tuple">
					<label class="index">주소</label>
					<input class="address" type="text" name="address" value="${memberDto.address}" disabled="disabled" />
				</div>
				
				<!-- 직업 -->
				<div class="tuple">
					<label class="index">직업</label>
					<select class="job" name="job" disabled="disabled">
						<option value="default">== 직업선택 ==</option>
						<option value="무직">무직</option>
						<option value="학생">학생</option>
						<option value="프로그래머">프로그래머</option>
						<option value="의사">의사</option>					
					</select>
					<script type="text/javascript">createForm.job.value = "${memberDto.job}"</script>
				</div>
				
				<!-- 메일 수신 -->
				<div class="tuple">
					<label class="index">메일수신</label>
					<input class="content" type="radio" name="mailing" value="yes" disabled="disabled" />yes
					<input class="content" type="radio" name="mailing" value="no" disabled="disabled" />no
				</div>
				<script type="text/javascript">
					for(var i=0; i<createForm.mailing.length; i++){
						if(createForm.mailing[i].value=="${memberDto.mailing}"){
							createForm.mailing[i].checked = true;
						}
					}
				</script>
				
				<!-- 관심 분야 -->
				<div class="tuple">
					<label class="index">관심분야</label>
					<input class="content" type="checkbox" name="interest" value="경제" disabled="disabled" />경제
					<input class="content" type="checkbox" name="interest" value="IT" disabled="disabled" />IT
					<input class="content" type="checkbox" name="interest" value="음악" disabled="disabled" />음악
					<input class="content" type="checkbox" name="interest" value="미술" disabled="disabled" />미술
					<input type="hidden" name="resultInterest" >
				</div>
				<c:forTokens var="interest" items="${memberDto.interest}" delims=" ">
					<script type="text/javascript">
						for(var i=0;i<createForm.interest.length;i++){
							if(createForm.interest[i].value=="${interest}"){
								createForm.interest[i].checked = true;
							}
						}
					</script>
				</c:forTokens>
				
				<!-- 버튼 -->
				<div class="foot">
					<input type="submit" value="탈퇴" />
					<input type="reset" value="취소" />
				</div>

			</form>
		</div>
	</div>
	
	

</body>

</html>