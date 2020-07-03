/**
 * @날짜 : 2020.07.02 ~ 03
 * @author : 이다은
 */

function createFormCheck(obj) {

	if (obj.id.value == "") {
		alert("아이디를 입력하세요.");
		obj.id.focus();
		return false;
	}
	
	if (obj.password.value.length < 7 || obj.password.value.length > 10) {
		alert("비밀번호를 7자 이상 10자 이하로 입력하세요.");
		obj.password.focus();
		return false;
	}
	
	if (obj.password.value != obj.passwordCheck.value) {
		alert("비밀번호가 다릅니다. 비밀번호를 확인하세요.");
		obj.passwordCheck.focus();
		return false;
	}
	
	if (obj.name.value == "") {
		alert("이름을 입력하세요.");
		obj.name.focus();
		return false;
	}

	if (obj.jumin1.value == "" || obj.jumin2.value == "") {
		alert("주민번호를 입력하세요.");
		obj.jumin1.focus();
		obj.jumin2.focus();
		return false;
	}
	
	if (obj.jumin1.value.length != 6 || obj.jumin2.value.length != 7 ) {
		alert("주민번호를 확인하세요.");
		obj.jumin1.focus();
		obj.jumin2.focus();
		return false;
	}
	
	if (obj.email.value == "") {
		alert("이메일을 입력하세요.");
		obj.email.focus();
		return false;
	}
	
	if (obj.zipcode.value == "") {
		alert("우편번호를 입력하세요.");
		obj.zipcode.focus();
		return false;
	}
	
	if (obj.address.value == "") {
		alert("주소를 입력하세요.");
		obj.address.focus();
		return false;
	}
	
	if(obj.job.value == "default"){
		alert("직업을 선택하세요.");
		return false;
	}
	
	if (obj.mailing.value == "") {
		alert("메일 수신 여부를 선택하세요.");
		return false;
	}

	var str = "";

	for (var i = 0; i < obj.interest.length; i++) {
		if (obj.interest[i].checked == true) {
			str += obj.interest[i].value + " ";
		}
	}
	
	obj.resultInterest.value = str;
	
	if (obj.resultInterest.value == "") {
		alert("관심분야를 하나 이상 선택하세요.");
		return false;
	}
}

function idCheck(obj, root) {
	// alert(obj.id.value);

	if (obj.id.value == "") {
		alert("아이디를 입력하세요");
		obj.id.value.focus();
		return false;
	}

	var url = root + "/member/idCheck.do?id=" + obj.id.value;
	// alert(url);
	// location.href=url;
	window.open(url, "", "width=400, height=600");
}

function zipcodeSearch(root) {
	var url = root + "/member/zipcode.do";
	// alert(url);
	window.open(url, "", "width=500, height=600, scrollbars=yes");
}

function sendZipcode(zipcode, sido, gugun, dong, ri, bunji) {
	var address = sido + " " + gugun + " " + dong + " " + ri + " " + bunji;
	alert(zipcode + " " + address);
	
	opener.createForm.zipcode.value = zipcode;
	opener.createForm.address.value = address;
	
	self.close();
}
