<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zxx">

<body>
    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__text">
                        <h4>Shop</h4>
                        <div class="breadcrumb__links">
                            <a href="./index.html">Home</a>
                            <span>Shop</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Shop Section Begin -->
    <section class="shop spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="shop__sidebar">
                        <div class="shop__sidebar__search">
                            <form action="#">
                                <input type="text" placeholder="Search...">
                                <button type="submit"><span class="icon_search"></span></button>
                            </form>
                        </div>
<!---------------------- 상품리스트;. ------------------------------->                       
                        <div class="shop__sidebar__accordion">
                            <div class="accordion" id="accordionExample">
                                <div class="card">
                                    <div class="card-heading">
                                        <a data-toggle="collapse" data-target="#collapseOne">Categories</a>
                                    </div>
                                    <div id="collapseOne" class="collapse show" data-parent="#accordionExample">
                                        <div class="card-body">
                                            <div class="shop__sidebar__categories">
                                                <ul class="nice-scroll">
                                                    <li><a href="javascript:Outer();">Outer</a></li>
                                                    <li><a href="javascript:Top();">Top</a></li>
                                                    <li><a href="javascript:Pants();">Pants</a></li>
                                                    <li><a href="javascript:Shoes();">Shoes</a></li>
                                                    <li><a href="javascript:Training();">Training</a></li>

                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
<!---------------------- 가격순 리스트;. ------------------------------->
                                <div class="card">
                                    <div class="card-heading">
                                        <a data-toggle="collapse" data-target="#collapseThree">Filter Price</a>
                                    </div>
                                    <div id="collapseThree" class="collapse show" data-parent="#accordionExample">
                                        <div class="card-body">
                                            <div class="shop__sidebar__price">
                                                <ul>
                                                    <li><a href="#">10,000원 - 30,000원</a></li>
                                                    <li><a href="#">30,000원 - 50,000원</a></li>
                                                    <li><a href="#">50,000원 - 80,000원</a></li>
                                                    <li><a href="#">80,000원 - 100,000원</a></li>
                                                    <li><a href="#">100,000원+</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
<!---------------------- 사이즈순;. ------------------------------->                                
                                <div class="card">
                                    <div class="card-heading">
                                        <a data-toggle="collapse" data-target="#collapseFour">Size</a>
                                    </div>
                                    <div id="collapseFour" class="collapse show" data-parent="#accordionExample">
                                        <div class="card-body">
                                            <div class="shop__sidebar__size">
                                                <label for="sm">s
                                                    <input type="radio" id="sm">
                                                </label>
                                                <label for="md">m
                                                    <input type="radio" id="md">
                                                </label>
                                                <label for="l">l
                                                    <input type="radio" id="xl">
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
<!---------------------- 컬러순;. ------------------------------->                                
                                <div class="card">
                                    <div class="card-heading">
                                        <a data-toggle="collapse" data-target="#collapseFive">Colors</a>
                                    </div>
                                    <div id="collapseFive" class="collapse show" data-parent="#accordionExample">
                                        <div class="card-body">
                                            <div class="shop__sidebar__color">
                                                <label class="c-1" for="sp-1">
                                                    <input type="radio" id="sp-1">
                                                </label>
                                                <label class="c-3" for="sp-3">
                                                    <input type="radio" id="sp-3">
                                                </label>
                                                <label class="c-9" for="sp-9">
                                                    <input type="radio" id="sp-9">
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
  
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="shop__product__option">
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="shop__product__option__left">
                                    <p>Showing 1–12 of 126 results</p>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="shop__product__option__right">
                                    <p>Sort by Price:</p>
                                    <select>
                                        <option value="">낮은가격</option>
                                        <option value="">높은가격</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>

<!---------------------- 상품목록;. ------------------------------->
                    <c:forEach var="vo" items="${product}">
                    <div class="row">
						<div class="col-lg-4 col-md-6 col-sm-6">
						
							<div class="product__item">
									<div class="product__item__pic set-bg"
										data-setbg="upload/${vo.pdImage1 }">
										<ul class="product__hover">
											<li><a href="#"><img src="img/icon/heart.png" alt=""></a></li>
											<li><a href="#"><img src="img/icon/compare.png"
													alt=""> <span>Compare</span></a></li>
											<li><a href="./shopdetails.do"><img src="img/icon/search.png"
													alt=""></a></li>
										</ul>
									</div>
									
									<div class="product__item__text">
										<h6>${vo.pdName}</h6>

										<h5>${vo.pdPrice}원</h5>
										<div class="product__color__select">
											<label for="pc-4"> <input type="radio" id="pc-4">
											</label> <label class="active black" for="pc-5"> <input
												type="radio" id="pc-5">
											</label> <label class="grey" for="pc-6"> <input type="radio"
												id="pc-6">
											</label>
										</div>
									</div>
								</div>
							
						</div>
					</div>
					</c:forEach>
            </div>
        </div>
    </section>
<!--------------------------------- 상품목록 끝 ------------------------------------------>


</body>

</html>