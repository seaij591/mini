<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div>
		<h1>회원 리스트</h1>
	</div>
	<div>
		<table class="table">
			<tr>
				<th align="center">아이디</th>
				<th align="center">비밀번호</th>
				<th align="center">이름</th>
				<th align="center">주소</th>
			</tr>
			<c:forEach var="vo" items="${members }">
				<tr>
					<td align="center">${vo.memberId}</td>
					<td align="center">${vo.memberPassword}</td>
					<td align="center">${vo.memberName }</td>
					<td align="center">${vo.memberAddress }</td>
					
				</tr>
			</c:forEach>
		</table>
	</div><br />
</div>
</body>
</html>