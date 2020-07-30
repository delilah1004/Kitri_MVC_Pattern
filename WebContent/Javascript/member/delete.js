/**
 * @날짜 : 2020.07.06
 * @author : 이다은
 */

function createFormCheck(obj, password) {	
	if (obj.password.value != password || obj.passwordCheck.value != password) {
		alert("비밀번호가 다릅니다. 비밀번호를 확인하세요.");
		obj.passwordCheck.focus();
		return false;
	}	
}