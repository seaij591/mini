package com.shop.product.service;

import java.util.List;

import com.shop.product.vo.ProductVO;

public interface ProductService {
	List<ProductVO> selectProductList();
	ProductVO selectProduct(ProductVO vo);
	public int insertProduct(ProductVO vo);
	public int updateProduct(ProductVO vo);
	public int deleteProduct(ProductVO vo);
	public ProductVO loginCheck(ProductVO vo);
}
