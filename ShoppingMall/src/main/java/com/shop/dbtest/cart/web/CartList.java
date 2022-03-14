package com.shop.dbtest.cart.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.DbCommand;
import com.shop.dbtest.cart.serviceImpl.CartServiceImpl;
import com.shop.dbtest.cart.vo.NewCartVO;

public class CartList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		CartServiceImpl dao = new CartServiceImpl();
		
		HttpSession session = request.getSession();
		String member_id = (String) session.getAttribute("id");
		

		
		List<NewCartVO> list = new ArrayList<NewCartVO>();
		list = dao.newCartSelectList(member_id);
		request.setAttribute("cart", list);
		return "cart/cartList.tiles";
	}

}
