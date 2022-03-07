package com.shop.product.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.common.DAO;
import com.shop.member.vo.MemberVO;
import com.shop.product.service.ProductService;
import com.shop.product.vo.ProductVO;

public class ProductServiceImpl extends DAO implements ProductService {
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public List<ProductVO> selectProductList() {
		//상품조회
		public List<ProductVO> selectProductVOList() {
			List<MemberVO> members = new ArrayList<MemberVO>();
			MemberVO vo;
			String sql = "SELECT * FROM MEMBERS";
			try {
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				while (rs.next()) {
					vo = new MemberVO();
					vo.setMemberId(rs.getString("member_id"));
					vo.setMemberPassword(rs.getString("member_password"));
					vo.setMemberName(rs.getString("member_name"));
					vo.setMemberAddress(rs.getString("member_address"));
					members.add(vo);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return members;
		}
		return null;
	}

	@Override
	public ProductVO selectProduct(ProductVO vo) {
		// 단품조회
		return null;
	}

	@Override
	public int insertProduct(ProductVO vo) {
		// 상품등록
		return 0;
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

}
