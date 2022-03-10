<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Page Preloder -->
<div id="preloder">
	<div class="loader"></div>
</div>

<!-- Offcanvas Menu Begin -->
<div class="offcanvas-menu-overlay"></div>
<div class="offcanvas-menu-wrapper">
	<div class="offcanvas__option">
		<div class="offcanvas__links">
			<a href="#">Sign in</a>

		</div>

		<div id="mobile-menu-wrap"></div>
		<div class="offcanvas__text">
			<p>Free shipping, 30-day return or refund guarantee.</p>
		</div>
	</div>
</div>
<!-- Offcanvas Menu End -->

<!-- Header Section Begin -->
<header class="header">
	<div class="header__top">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-7">
					<div class="header__top__left">
						<p>키큰 남자들의 쇼핑몰</p>
					</div>
				</div>
				<div class="col-lg-6 col-md-5">
					<div class="header__top__right">
						<div class="header__top__links">


							<%
							if (session.getAttribute("id") == null) { //mid의 속성이 없으면 로그인 이전화면
							%>
							<li><a href="<%=request.getContextPath()%>/login.do"
								class="button alt">SIGN IN</a></li>
							<%
							} else {
							%>

							<li><a href="<%=request.getContextPath()%>/memberLogOut.do"
								class="button alt">LOG OUT</a></li>
							<%
							}
							%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-md-3">
				<div class="header__logo">
					<a href="./index.jsp"><img src="img/logo.png" alt=""></a>
				</div>
			</div>
			<div class="col-lg-6 col-md-6">
				<nav class="header__menu mobile-menu">
					<ul>
						<li><a href="./index.jsp">Home</a></li>
						<li><a href="./shop.do">Shop</a></li>

						<li><a href="./about.do">About Us</a></li>

											<c:if test="${not empty id and id ne 'admin'}">		
						<li><a href="#">My Page</a>
							<ul class="dropdown">
								<li><a href="cartList.do">장바구니</a></li>
								<li><a href="./.html">주문내역</a></li>
								<li><a href="./.html">좋아요</a></li>
								<li><a href="./.html">최근 본 상품</a></li>
							</ul></li>
					</c:if>

						<li><a href="#">Community</a>
							<ul class="dropdown">
								<li><a href="noticeList.do">공지사항</a></li>
								<li><a href="./.html">자주묻는질문</a></li>
								<li><a href="./inquiry.do">문의</a></li>
								<li><a href="./support.do">고객지원센터</a></li>
							</ul></li>

						<c:if test="${id eq 'admin'}">
							<li><a href="#">Admin Menu</a>
								<ul class="dropdown">
									<li><a href="./productForm.do">상품등록/수정</a></li>
									<li><a href="./memberList.do">회원리스트</a></li>
								</ul></li>
						</c:if>

					</ul>
				</nav>
			</div>
			<div class="col-lg-3 col-md-3">
				<div class="header__nav__option">
					<a href="#" class="search-switch"><img
						src="img/icon/search.png" alt=""></a> <a href="#"><img
						src="img/icon/heart.png" alt=""></a> <a href="#"><img
						src="img/icon/cart.png" alt=""> <span>0</span></a>
				</div>
			</div>
		</div>
		<div class="canvas__open">
			<i class="fa fa-bars"></i>
		</div>
	</div>
</header>
<!-- Header Section End -->