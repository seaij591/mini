<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <div align="center">
	<div>
		<h1>문의 내용</h1>
	</div>
	<div>
		<table border="1">
			<tr>
				<th width="70">순번</th>
				<td width="70" align="center">${vo.num }</td>
				<th width="70">작성일자</th>
				<td width="70" align="center">${vo.wdate }</td>
				<th width="70">조회수</th>
				<td width="70" align="center">${vo.hit }</td>
			</tr>
			<tr>
				<th width="70">제목</th>
				<td colspan="5">${vo.title }</td>
				<th width="70">작성자</th>
				<td width="70" align="center">${vo.id }</td>
			</tr>
			<tr>
				<th width="70">내용</th>
				<td colspan="5"><textarea rows="6" cols="90">${vo.content}</textarea>
				</td>
			</tr>
		</table>
	</div>
	<br />
	<div>
		<button type="button" onclick="location.href='inquiryList.do'">목록보기</button>
		<button type="button" onclick="location.href=#">변경하기</button>
	</div>
</div>