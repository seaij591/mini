<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String member_name = request.getParameter("member_name");
String member_phone = request.getParameter("member_phone");

MemberDao dao = new MemberDao();
String member_mid = dao.findId(member_name, member_phone); //아이디를 디비에서 가져옴..실패시 널
%>

<form name="idsearch" method="post">
	<%
	if (member_mid != null) {
	%>

	<div class="container">
		<div class="found-success">
			<h4>회원님의 아이디는</h4>
			<div class="found-id"><%=member_mid%></div>
			<h4>입니다</h4>
		</div>
		<div class="found-login">
			<input type="button" id="btnLogin" value="로그인" onClick='login()' />
		</div>
	</div>
	<%
	} else {
	%>
	<div class="container">
		<div class="found-fail">
			<h4>등록된 정보가 없습니다</h4>
		</div>
		<div class="found-login">
			<input type="button" id="btnback" value="다시 찾기"
				onClick="history.back()" /> <input type="button" id="btnjoin"
				value="회원가입" onClick="joinin()" />
		</div>
	</div>


	<%
	}
	%>
</form>