<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<script type="text/javascript">
	function formCheck() {
		if(frm.memberId.value == ""){
			alert("아이디를 입력하세요.");
			frm.memberId.focus();
			return false;
		}
		
		if(frm.memberPassword.value ==""){
			alert("패스워드를 입력하세요.");
			frm.memberPassword.focus();
			return false;
		}
		
		frm.submit();
	}
	
</script>	

<html>
<head>
<title>Login 04</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
<link href="https://fonts.googleapis.com/css?family=Lato:400,500,700&display=swap" rel="stylesheet">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="./css/login/style.css">

<script src="js/login/jquery.min.js"></script>
<script src="js/login/popper.js"></script>
<script src="js/login/bootstrap.min.js"></script>
<script src="js/login/main.js"></script>


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
				<div class="col-md-12 col-lg-10">
					<div class="wrap d-md-flex">
						<div class="img" style="background-image: url(img/login/login1.png);">
						</div>
						<div class="login-wrap p-4 p-md-5">
							<div class="d-flex">
								<div class="w-100">
									<h3 class="mb-4">로그인</h3>
								</div>
								<div class="w-100">
									
								</div>
							</div>
							<div>
							<form id="frm" name="frm" action="memberLogin.do" method="post">
								<div class="form-group mb-3">
									<label class="label" for="name">이름</label> <input
										type="text" id="memberId" name="memberId" class="form-control" placeholder="Username"
										required>
								</div>
								<div class="form-group mb-3">
									<label class="label" for="password">비밀번호</label> <input
										type="password" id="memberPassword" name="memberPassword" class="form-control" placeholder="Password"
										required>
								</div>
								<div class="form-group">
									<button type="button" onclick="formCheck()"
										class="form-control btn btn-primary rounded submit px-3">로그인</button>
								</div>
								
									<div>
										<a href="./signup.do">회원가입</a><br>
										<a href="#">아이디찾기</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="#">비밀번호찾기</a><br>
									
										
									</div>
									</form>
								</div>
							
							</div>
						</div>
					</div>
				</div>
			</div>
	
	</section>


</body>
</html>

