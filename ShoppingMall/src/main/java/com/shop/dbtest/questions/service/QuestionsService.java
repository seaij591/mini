package com.shop.dbtest.questions.service;

import java.util.List;

import com.shop.dbtest.questions.vo.QuestionsVO;

public interface QuestionsService {
	List<QuestionsVO> questionsSelectList();
	QuestionsVO questionsSelect(QuestionsVO vo);
	int insertQuestions(QuestionsVO vo);
	int updateQuestions(QuestionsVO vo);
	int deleteQuestions(QuestionsVO vo);
	
	

}
