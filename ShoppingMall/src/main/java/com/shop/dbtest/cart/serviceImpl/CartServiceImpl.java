package com.shop.dbtest.cart.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.common.DAO;
import com.shop.dbtest.cart.service.CartService;
import com.shop.dbtest.cart.vo.CartVO;
import com.shop.dbtest.cart.vo.NewCartVO;

public class CartServiceImpl extends DAO implements CartService {

	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<CartVO> cartSelectList() {
		List<CartVO> list = new ArrayList<CartVO>();
		CartVO vo;
		String sql = "select * from cart";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new CartVO();
				vo.setMember_id(rs.getString("member_id"));
				vo.setPd_id(rs.getString("pd_id"));
				vo.setPd_quantity(rs.getInt("pd_quantity"));
				vo.setPd_color(rs.getString("pd_color"));
				vo.setPd_size(rs.getString("pd_size"));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

	//조인된 NewCartVO 전체조회 리스트에 담기
	@Override
	public List<NewCartVO> newCartSelectList() {
		// TODO Auto-generated method stub
		List<NewCartVO> list = new ArrayList<NewCartVO>();
		NewCartVO vo;
		String sql = "SELECT  c.member_id, c.pd_id, p.pd_name, p.pd_price, c.pd_quantity, c.pd_color, c.pd_size FROM product p , cart c WHERE c.pd_id = p.pd_id";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new NewCartVO();
				vo.setMember_id(rs.getString("member_id"));
				vo.setPd_id(rs.getString("pd_id"));
				vo.setPd_name(rs.getString("pd_name"));
				vo.setPd_price(rs.getInt("pd_price"));
				vo.setPd_quantity(rs.getInt("pd_quantity"));
				vo.setPd_color(rs.getString("pd_color"));
				vo.setPd_size(rs.getString("pd_size"));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

	@Override
	public CartVO cartSelect(CartVO vo) {
		String sql = "select * from cart where member_id = ?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getMember_id());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setMember_id(rs.getString("member_id"));
				vo.setPd_id(rs.getString("pd_id"));
				vo.setPd_quantity(rs.getInt("pd_quantity"));
				vo.setPd_color(rs.getString("pd_color"));
				vo.setPd_size(rs.getString("pd_size"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	@Override
	public int insertCart(CartVO vo) {
		String sql = "insert into cart values(?,?,?,?,?)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMember_id());
			psmt.setString(2, vo.getPd_id());
			psmt.setInt(3, vo.getPd_quantity());
			psmt.setString(4, vo.getPd_color());
			psmt.setString(5, vo.getPd_size());
			n = psmt.executeUpdate();
			System.out.println(n + "건 입력.");
			
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int updateCart(CartVO vo) {
		// TODO Auto-generated method stub
		String sql = "update cart set pd_quantity = ?, pd_color = ?, pd_size = ? where id = ?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getPd_quantity());
			psmt.setString(2, vo.getPd_color());
			psmt.setString(3, vo.getPd_size());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}

	@Override
	public int deleteCart(CartVO vo) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM CART WHERE MEMBER_ID = ?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMember_id());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
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
