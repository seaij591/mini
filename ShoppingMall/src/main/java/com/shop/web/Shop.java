package com.shop.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.product.service.ProductService;
import com.shop.product.serviceImpl.ProductServiceImpl;
import com.shop.product.vo.ProductVO;

public class Shop implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String category = request.getParameter("cat");
		ProductService service = new ProductServiceImpl();
		List<ProductVO> list = service.selectShopForm(category);
		request.setAttribute("product", list);
		
		return "shopinfo/shopmain.tiles";
	}
}
