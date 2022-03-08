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
		<h1>상품등록</h1>
	</div>
	<div>
		<table class="table">
			<tr>
				<th align="center">상품번호</th>
				<th align="center">카테고리</th>
				<th align="center">이름</th>
				<th align="center">사이즈</th>
				<th align="center">컬러</th>
				<th align="center">가격</th>
				<th align="center">내용</th>
				<th align="center">이미지1</th>
				<th align="center">이미지2</th>
				<th align="center">이미지3</th>
			</tr>
			<c:forEach var="vo" items="${product}">
				<tr>
					<td align="center">${vo.pdId}</td>
					<td align="center">${vo.pdCategory}</td>
					<td align="center">${vo.pdName }</td>
					<td align="center">${vo.pdSize }</td>
					<td align="center">${vo.pdColor }</td>
					<td align="center">${vo.pdPrice }원</td>
					<td align="center">${vo.pdContent }</td>	
					<td align="center">${vo.pdImage1 }</td>
					<td align="center">${vo.pdImage2 }</td>
					<td align="center">${vo.pdImage3 }</td>
				</tr>
			</c:forEach>
		</table>
	</div><br />
	<div>
		<button type="button" onClick="location.href='main.do'">홈</button>&nbsp;&nbsp;&nbsp;
		<c:if test="${not empty id }">
			<button type="button" onClick="location.href='productInsertForm.do'">등록</button>
		</c:if>
	</div>
</div>
</body>