package com.shop.dbtest.inquiry.service;

import java.util.List;

import com.shop.dbtest.inquiry.vo.InquiryVO;

public interface InquiryService {
	List<InquiryVO> inquirySelectList();
	InquiryVO inquirySelect(InquiryVO vo);
	int insertInquiry(InquiryVO vo);
	int updateInquiry(InquiryVO vo);
	int deleteInquiry(InquiryVO vo);
}
