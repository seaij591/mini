function pw_search() {
	var frm = document.forms.pwfindscreen;

	if (frm.member_id.value.length < 1) {
		alert("아이디를 입력해주세요");
		return;
	}
	if (frm.member_name.value.length < 1) {
		alert("이름을 입력해주세요");
		return;
	}
	if (frm.member_tel.value.length != 11) {
		alert("핸드폰번호를 정확하게 입력해주세요");
		return;
	}
	
	pwfindscreen.method = "post";
	pwfindscreen.action = "findPwResult.do";
	pwfindscreen.submit();
}