package com.shop.dbtest.inquiry.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.dbtest.inquiry.serviceImpl.InquiryServiceImpl;
import com.shop.dbtest.inquiry.vo.InquiryVO;

public class InquiryList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 문의 전체보기
		InquiryServiceImpl dao = new InquiryServiceImpl();
		List<InquiryVO> list = new ArrayList<InquiryVO>();
		
		list = dao.inquirySelectList();
		request.setAttribute("inquiries", list);
		
		return "inquiry/inquiryList.tiles";
	}

}
