package com.shop.web;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.DbCommand;
import com.shop.product.serviceImpl.ProductServiceImpl;
import com.shop.product.vo.ProductVO;

public class Shopdetails implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		ProductServiceImpl service = new ProductServiceImpl();
		ProductVO vo = new ProductVO();
		vo.setPdId(request.getParameter("pdId"));
		vo = service.selectProduct(vo);
		request.setAttribute("product", vo);
		
		return "shopinfo/shopdetails.tiles";
	}

}
