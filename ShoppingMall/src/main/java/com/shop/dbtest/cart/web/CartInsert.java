package com.shop.dbtest.cart.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.DbCommand;
import com.shop.dbtest.cart.serviceImpl.CartServiceImpl;
import com.shop.dbtest.cart.vo.CartVO;

public class CartInsert implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		CartServiceImpl dao = new CartServiceImpl();
		HttpSession session = request.getSession();
		String member_id = (String) session.getAttribute("id");
		CartVO vo = new CartVO();
		List<CartVO> list = dao.cartSelectListById(member_id);
		
		vo.setMember_id(member_id);
		String color = request.getParameter("pd_color");
		vo.setPd_color(color);
		vo.setPd_id(request.getParameter("pd_id"));
		vo.setPd_quantity(Integer.parseInt(request.getParameter("pd_quantity")));
		vo.setPd_size(request.getParameter("pd_size"));
		
		
		if(!list.isEmpty()) {
			return "cartCheckFail.do";
		}
		else {
			int n = dao.insertCart(vo);
			return "cartList.do";
		}
	
		
		


	}

}
