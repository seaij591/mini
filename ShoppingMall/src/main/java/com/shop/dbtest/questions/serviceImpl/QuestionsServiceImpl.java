package com.shop.dbtest.questions.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.common.DAO;
import com.shop.dbtest.questions.service.QuestionsService;
import com.shop.dbtest.questions.vo.QuestionsVO;

public class QuestionsServiceImpl extends DAO implements QuestionsService {

	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<QuestionsVO> questionsSelectList() {
		// 전체 조회
		List<QuestionsVO> list = new ArrayList<QuestionsVO>();
		QuestionsVO vo;
		String sql = "select * from questions";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new QuestionsVO();
				vo.setId(rs.getInt("id"));
				vo.setType(rs.getString("type"));
				vo.setTitle("title");
				vo.setContent("content");
				vo.setWdate(rs.getDate("wdate"));
				vo.setHit(rs.getInt("hit"));
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public QuestionsVO questionsSelect(QuestionsVO vo) {
		String sql = "select * from questions where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setType(rs.getString("type"));
				vo.setTitle(rs.getString("title"));
				vo.setContent("content");
				vo.setWdate(rs.getDate("wdate"));
				vo.setHit(rs.getInt("hit"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertQuestions(QuestionsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateQuestions(QuestionsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteQuestions(QuestionsVO vo) {
		// TODO Auto-generated method stub
		return 0;
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
