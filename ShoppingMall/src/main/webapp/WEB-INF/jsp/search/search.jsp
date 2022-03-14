<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container">
	<div class="row">
		<form method="post" name="search" action="searchProduct.do">
			<table class="pull-right">
				<tr>
					<td><input type="text" class="form-control"
						placeholder="검색어 입력" id="text" name="text" maxlength="100"></td>
					<td><button type="submit" class="btn btn-success">검색</button></td>
				</tr>

			</table>
		</form>
	</div>
</div>