<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>

<body>
	<form action="productInsert.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="writer" id="writer" value="${id }">
		<table border="1">
			<tr>
				<th>상품명:</th>
				<td><input type="text" name="pdName" id="pdName"></td>
			</tr>
			<tr>
				<td>상품번호:</td>
				<td><input type="text" name="pdId" id="pdId"></td>
			</tr>
			<tr>
				<td>카테고리:</td>
				<td><input type="text" name="pdCategory" id="pdCategory"></td>
			</tr>
			<tr>
				<td>가격:</td>
				<td><input type="text" name="pdPrice" id="pdPrice"></td>
			</tr>
			<tr>
				<td>내용:</td>
				<td><input type="text" name="pdContent1" id="pdContent1"></td>
			</tr>
			<tr>
				<td>메인내용:</td>
				<td><input type="text" name="pdContent2" id="pdContent2"></td>
			</tr>
			<tr>
				<td>이미지1:</td>
				<td><input type="file" name="pdImage1" id="pdImage1"></td>
			</tr>
			<tr>
				<td>이미지2:</td>
				<td><input type="file" name="pdImage2" id="pdImage2"></td>
			</tr>
			<tr>
				<td>이미지3:</td>
				<td><input type="file" name="pdImage3" id="pdImage3"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit"
					value="upload"></td>
			</tr>
		</table>
	</form>
</body>

</html>