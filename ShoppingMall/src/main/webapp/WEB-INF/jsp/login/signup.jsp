<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/signup/jquery.min.js"></script>
<script src="js/signup/popper.js"></script>
<script src="js/signup/bootstrap.min.js"></script>
<script src="js/signup/main.js"></script>

<script>
	$(function () {
		$('#memberId').change(function () {
			$('#idCheck').val('unChecked');
		});

		//idCheck 버튼을 클릭했을 때 
		$("#idCheck").click(function () {
			var userid = $("#memberId").val();

			$.ajax({
				type: 'POST',
				data: {
					id: userid
				},
				url: "ajaxMemberIdCheck", //별도 서블릿으로 만들었다. *.do에서 제외(컨트롤러 안탐)
				success: function (data) {
					if (data > 0) {
						alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
						$("#memberId").val("");
						$("#memberId").focus();
					} else {
						alert("사용가능한 아이디입니다.");
						$("#idCheck").val("checked");
						$("#memberPassword").focus();
					}
				},
				error: function (error) {
					alert("error : " + error);
				}
			});
		});
	});
</script>

<script type="text/javascript">
	function formCheck() {
		if (frm.memberId.value == "") {
			alert("아이디를 입력하세요.");
			frm.memberId.focus();
			return false;
		}

		if (frm.idCheck.value == "unChecked") {
			alert("아이디 중복체크를 하세요.");
			return false;
		}

		if (frm.memberPassword.value == "") {
			alert("패스워드를 입력하세요.");
			frm.memberPassword.focus();
			return false;
		}
		if(frm.memberPassword.value != frm.memberPassword1.value){
			alert("패스워드가 일치하지 않습니다.");
			frm.memberPassword.value="";
			frm.memberPassword1.value="";
			frm.memberPassword.focus();
			return false;
		}
		
		frm.submit();
	}

	function idCheckDo() {
		var id = frm.memberId.value;
		window.open("/DbTest/idCheck.do?id=" + id, "childForm", "width=570, height=350, resizable = no, scrollbars = no");

	}
</script>

<html>
<head>
<title>Sign Up 10</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="./css/signup/style.css">

</head>
<body>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">키 큰 남 자</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-lg-10">
					<div class="wrap d-md-flex">
						<div
							class="text-wrap p-4 p-lg-5 d-flex img d-flex align-items-end"
							style="background-image: url(img/signup/signup.png);">
							<div class="text w-100">
								<h2 class="mb-4">환영합니다!</h2>
								<p>저희 키큰남자에서 고객님의 스타일에 딱 맞는 옷을 찾아보세요!</p>
							</div>
						</div>
						<div class="login-wrap p-4 p-md-5">
							<h3 class="mb-3">회 원 가 입</h3>
							<div>
							<form id="frm" name="frm" action="memberJoin.do" method="post">
							
								<div class="row">
									<div class="col-md-12">
										<div class="form-group d-flex align-items-center">
											<label class="label" for="name">아이디</label> 
											<input type="text" id="memberId" name="memberId" class="form-control" 
												   placeholder="ID">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												
											<button type="button" id="idCheck" name="idCheck" value="unChecked">중복체크</button>
										</div>
									</div>
									
									<div class="col-md-12">
										<div class="form-group d-flex align-items-center">
											<label class="label" for="email">비밀번호</label> 
											<input type="password" id="memberPassword" name="memberPassword" class="form-control"
												placeholder="Password">
										</div>
									</div>
									
									<div class="col-md-12">
										<div class="form-group d-flex align-items-center">
											<label class="label" for="phone">비밀번호 확인</label> 
											<input type="password" id="memberPassword1" name="memberPassword1" class="form-control" placeholder="Password">
										</div>
									</div>
									
									<div class="col-md-12">
										<div class="form-group d-flex align-items-center">
											<label class="label" for="phone">이름</label> 
											<input type="text" id="memberName" name="memberName" class="form-control" placeholder="Your Name">
										</div>
									</div>
									<div class="col-md-12">
										<div class="form-group d-flex align-items-center">
											<label class="label" for="password">주소</label> 
											<input type="text" id="memberAddress" name="memberAddress" class="form-control" placeholder="대구 중구...">
										</div>
									</div>

									<div class="col-md-50">
										<div class="form-group">
											<button type="button" onclick="formCheck()" class="btn btn-secondary submit p-3">Create
												an account</button>
										</div>
									</div>
								</div>

							</form>
							<div class="social-wrap">
								<p class="or">

							<div class="w-100 text-center">
								<p class="mt-4">
									이미 회원가입이 되어있으십니까? <a href="./login.do">로그인으로</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	

</body>
</html>

