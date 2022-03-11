package com.shop.dbtest.inquiry.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shop.common.DAO;
import com.shop.dbtest.inquiry.service.InquiryService;
import com.shop.dbtest.inquiry.vo.InquiryVO;

public class InquiryServiceImpl extends DAO implements InquiryService{
	private PreparedStatement psmt;
	private ResultSet rs;
	
	
	
	@Override
	public List<InquiryVO> inquirySelectList() {
		List<InquiryVO> list = new ArrayList<InquiryVO>();
		InquiryVO vo;
		String sql = "SELECT * FROM inquiry";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new InquiryVO();
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWdate(rs.getDate("wdate"));
				vo.setHit(rs.getInt("hit"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	@Override
	public InquiryVO inquirySelect(InquiryVO vo) {
		String sql = "SELECT * FROM inquiry WHERE num = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getNum());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setTitle(rs.getString("title"));;
				vo.setContent(rs.getString("content"));
				vo.setId(rs.getString("id"));
				vo.setWdate(rs.getDate("wdate"));
				vo.setHit(rs.getInt("hit"));
				hitCount(vo.getNum()); //조회수 증가 메소드
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		return vo;
	}
	@Override
	public int insertInquiry(InquiryVO vo) {
		int n = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT inquiry_seq.nextval FROM dual");
			rs.next();
			int num = rs.getInt(1);
			vo.setNum(num);
			
			
			String sql = "INSERT INTO inquiry(num, title, content, id, wdate) VALUES (?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getNum());
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			psmt.setString(4, vo.getId());
			psmt.setDate(5, vo.getWdate());
			
			n = psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	@Override
	public int updateInquiry(InquiryVO vo) {
		int n = 0;
		String sql = "UPDATE inquiry SET title=?, content=? WHERE num=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getNum());
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}
	@Override
	public int deleteInquiry(InquiryVO vo) {
		int n = 0;
		String sql = "DELETE inquiry WHERE num=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getNum());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public List<InquiryVO> selectInquiryListPaging(int page){
		String sql = "SELECT b.rn\r\n"//
				+ "      ,b.*\r\n"//
				+ "FROM   (SELECT ROWNUM rn\r\n"//
				+ "              ,a.*\r\n"//
				+ "        FROM   (SELECT *\r\n"//
				+ "                FROM   notice\r\n"//
				+ "                ORDER  BY 1) a) b\r\n"//
				+ "WHERE  b.rn BETWEEN ? AND ?";
		
		List<InquiryVO> list = new ArrayList<>();
		int firstCnt = 0, lastCnt = 0;
		
		firstCnt = (page - 1) * 10 + 1;
		lastCnt = (page * 10);
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, firstCnt);
			psmt.setInt(2, lastCnt);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				InquiryVO  vo = new InquiryVO();
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWdate(rs.getDate("wdate"));
				vo.setHit(rs.getInt("hit"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		return list;
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

	private void hitCount(int num) {
		int count = 0;
		try {
			String getHitSql = "SELECT hit FROM inquiry WHERE num = ?";
			psmt = conn.prepareStatement(getHitSql);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
				count++;
			}
			
			String sql = "UPDATE inquiry SET hit = ? WHERE num = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, count);
			psmt.setInt(2, num);
			psmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
	

