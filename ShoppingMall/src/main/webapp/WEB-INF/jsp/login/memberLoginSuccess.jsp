<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인성공</title>
</head>
<script>
	alert('${member.memberName}님 환영합니다.');
	location.href = "main.do";
	//history.go(-2); //가장 최근에 보고있던 페이지로 넘어감 대신 새로고침을해야 로그아웃메뉴가생김
</script>
<body>

</body>
</html>