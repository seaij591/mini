package com.shop.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.product.service.ProductService;
import com.shop.product.serviceImpl.ProductServiceImpl;
import com.shop.product.vo.ProductVO;

public class ProductSelect implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		System.out.println("cont: " + id);

		ProductVO vo = new ProductVO();
		vo.setPdId(id);

		ProductService service = new ProductServiceImpl();
		vo = service.selectProduct(vo);

		request.setAttribute("bulletin", vo);

		return "product/bulletin.tiles";
	}

}