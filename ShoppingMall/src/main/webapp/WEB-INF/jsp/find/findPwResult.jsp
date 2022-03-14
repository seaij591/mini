<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<form name="pwsearch" method="post">

	<c:choose>
		<c:when test="${pw != null }">
			<div class="container">
				<div class="found-success">
					<h4>회원님의 비밀번호는<div class="found-pw"> ${pw }</div>입니다</h4>
				</div>
				<div class="found-login">
					<input type="button" id="btnLogin" value="로그인" onClick="location.href='login.do'" />
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="container">
				<div class="found-fail">
					<h4>등록된 정보가 없습니다</h4>
				</div>
				<div class="found-login">
					<input type="button" id="btnback" value="다시 찾기"
						onClick="history.back()" /> <input type="button" id="btnjoin"
						value="회원가입" onClick="location.href='signup.do'" />
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</form>