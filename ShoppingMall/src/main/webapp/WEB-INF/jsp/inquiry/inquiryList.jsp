<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function formSubmit(id) {
		frm.num.value = id;
		frm.submit();
	}
</script>
<div>
	<br />
</div>
<div align="center">
	<div>
		<h3>문의 게시판</h3>
	</div>
	<form id="frm" name="frm" action="inquiry.do" method="post">
		<input type="hidden" id="num" name="num">
	</form>
	<div>
		<table class="table">
			<tr>
				<th width="30">순번</th>
				<th width="200">제목</th>
				<th width="200">작성자</th>
				<th width="100">작성일자</th>
				<th width="100">조회수</th>
			</tr>
			<c:forEach var="vo" items="${inquiries }">
				<tr onclick="formSubmit(${vo.num})">
					<td align="center">${vo.num }</td>
					<td align="center">${vo.title }</td>
					<td align="center">${vo.id }</td>
					<td align="center">${vo.wdate }</td>
					<td align="center">${vo.hit }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br />
	<div>
		<button type="button" onClick="location.href='main.do'">홈</button>
		&nbsp;&nbsp;&nbsp;
		<c:if test="${id != null }">
			<button type="button" onClick="location.href='inquiryForm.do'">등록</button>
		</c:if>
	</div>
	
</div>