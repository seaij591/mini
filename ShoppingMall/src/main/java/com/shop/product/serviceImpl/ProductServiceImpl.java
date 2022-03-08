package com.shop.product.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.common.DAO;
import com.shop.product.service.ProductService;
import com.shop.product.vo.ProductVO;

public class ProductServiceImpl extends DAO implements ProductService {
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<ProductVO> selectProductList() {
		// 상품조회
		List<ProductVO> products = new ArrayList<ProductVO>();
		ProductVO vo;
		String sql = "SELECT * FROM PRODUCT";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new ProductVO();
				vo.setPdId(rs.getString("pd_id"));
				vo.setPdCategory(rs.getString("pd_category"));
				vo.setPdName(rs.getString("pd_name"));
				vo.setPdSize(rs.getString("pd_size"));
				vo.setPdColor(rs.getString("pd_color"));
				vo.setPdPrice(rs.getString("pd_price"));
				vo.setPdImage1(rs.getString("pd_image1"));
				vo.setPdImage2(rs.getString("pd_image2"));
				vo.setPdImage3(rs.getString("pd_image3"));
				vo.setPdContent(rs.getString("pd_content"));
				products.add(vo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return products;
	}

	@Override
	public ProductVO selectProduct(ProductVO vo) {
		// 단품조회
		return null;
	}

	@Override
	public int insertProduct(ProductVO vo) {
		// 상품등록
		String sql = "insert into product(pd_image1,pd_image2,pd_image3,pd_id,pd_category,pd_name,pd_size,pd_color,pd_price,pd_content) values(?,?,?,?,?,?,?,?,?,?)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPdImage1());
			psmt.setString(2, vo.getPdImage2());
			psmt.setString(3, vo.getPdImage3());
			psmt.setString(4, vo.getPdId());
			psmt.setString(5, vo.getPdCategory());
			psmt.setString(6, vo.getPdName());
			psmt.setString(7, vo.getPdSize());
			psmt.setString(8, vo.getPdColor());
			psmt.setString(9, vo.getPdPrice());
			psmt.setString(10, vo.getPdContent());
			r = psmt.executeUpdate();
			System.out.println(r + "건 등록.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}
	@Override
	public int updateProduct(ProductVO vo) {
		// 상품수정
		return 0;
	}

	@Override
	public int deleteProduct(ProductVO vo) {
		// 상품삭제
		return 0;
	}

	@Override
	public ProductVO loginCheck(ProductVO vo) {
		// 관리자 체크
		return null;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
