package com.shop.dbtest.cart.service;

import java.util.List;

import com.shop.dbtest.cart.vo.CartVO;

public interface CartService {
	List<CartVO> cartSelectList();
	CartVO cartSelect(CartVO vo);
	int insertCart(CartVO vo);
	int updateCart(CartVO vo);
	int deleteCart(CartVO vo);
}
