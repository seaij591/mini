<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form name="pwfindscreen" method="POST" action="">
	<div class="search-title">
		<h3>비밀번호 찾기</h3>
	</div>
	<section class="form-search">
		<div class="find-id">
			<label>아이디</label> <input type="text" name="member_id"
				class="btn-id" placeholder="아이디"> <br>
		</div>
		<div class="find-name">
			<label>이름</label> <input type="text" name="member_name"
				class="btn-name" placeholder="등록한 이름"> <br>
		</div>
		<div class="find-phone">
			<label>번호</label> <input type="text" name="member_tel"
				class="btn-phone" placeholder="휴대폰번호를 '-'없이 입력">
		</div>
		<br>
	</section>
	<div class="btnSearch">
		<input type="button" name="enter" value="찾기" onClick="pw_search()">
		<input type="button" name="cancle" value="취소" onClick="history.back()">
	</div>
</form>
<script src="js/find/findPwInfo.js"></script>