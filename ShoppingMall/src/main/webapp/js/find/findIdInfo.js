function id_search() { 
	 	var frm = document.forms.idfindscreen;

	 	if (frm.member_name.value.length < 1) {
		  alert("이름을 입력해주세요");
		  return;
		 }

		 if (frm.member_tel.value.length != 11) {
			  alert("핸드폰번호를 정확하게 입력해주세요");
			  return;
		 }

	 idfindscreen.method = "post";
	 idfindscreen.action = "findIdResult.do"; //넘어간화면
	 idfindscreen.submit();  
	 }