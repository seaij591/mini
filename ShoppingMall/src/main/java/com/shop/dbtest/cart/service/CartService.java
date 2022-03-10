package com.shop.dbtest.cart.service;

import java.util.List;

import com.shop.dbtest.cart.vo.CartVO;
import com.shop.dbtest.cart.vo.NewCartVO;

public interface CartService {
	List<NewCartVO> newCartSelectList();
	List<CartVO> cartSelectList();
	CartVO cartSelect(CartVO vo);
	int insertCart(CartVO vo);
	int updateCart(CartVO vo);
	int deleteCart(CartVO vo);
}
