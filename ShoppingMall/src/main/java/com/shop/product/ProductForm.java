package com.shop.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.product.service.ProductService;
import com.shop.product.serviceImpl.ProductServiceImpl;
import com.shop.product.vo.ProductVO;

public class ProductForm implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 상품 등록,수정
		ProductService service = new ProductServiceImpl();
		List<ProductVO> list = service.selectProductList();
		request.setAttribute("product", list);

		return "product/productForm.tiles";
	}

}
