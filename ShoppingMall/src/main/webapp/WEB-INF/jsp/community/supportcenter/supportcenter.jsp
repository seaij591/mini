<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의하기</title>
</head>
<body>
	<!-- Contact Section Begin -->
	<section class="contact spad">
		<div class="container">
			<p>
				<img src="img/company.png" alt="">
			</p>
			<div class="support">
				<a href=""></a>
			</div>
			<div class="bank_layer">
				<select style="height: 10px; font-size: 10px;"
					onchange="if(this.value) window.open(this.value);"><option
						value="">인터넷뱅킹 바로가기</option>
					<option value="https://www.ibk.co.kr/">기업은행</option>
					<option value="https://www.kbstar.com/">국민은행</option>
					<option value="https://banking.nonghyup.com/">농협</option>
					<option value="https://www.shinhan.com/">신한은행</option>
					<option value="https://www.wooribank.com/">우리은행</option></select>
			</div>
		</div>
	</section>
	<!-- Contact Section End -->
</body>
</html>