package com.shop.dbtest.cart.service;

import java.util.List;

import com.shop.dbtest.cart.vo.CartVO;
import com.shop.dbtest.cart.vo.NewCartVO;

public interface CartService {
	List<NewCartVO> newCartSelectList(String member_id);
	List<CartVO> cartSelectList();
	List<CartVO> cartSelectListById(String member_id);
	CartVO cartSelect(CartVO vo);
	int insertCart(CartVO vo);
	int updateCart(CartVO vo);
	int deleteCart(CartVO vo);
}
