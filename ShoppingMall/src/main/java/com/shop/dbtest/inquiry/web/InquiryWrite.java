package com.shop.dbtest.inquiry.web;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.dbtest.inquiry.serviceImpl.InquiryServiceImpl;
import com.shop.dbtest.inquiry.vo.InquiryVO;

import oracle.sql.DATE;

public class InquiryWrite implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		InquiryServiceImpl dao = new InquiryServiceImpl();
		InquiryVO vo = new InquiryVO();
		
		vo.setTitle(request.getParameter("title"));
		vo.setId(request.getParameter("id"));
		vo.setContent(request.getParameter("content"));
		vo.setWdate(Date.valueOf(request.getParameter("wdate")));
		
		dao.insertInquiry(vo);
		
		return "inquiryList.do";
	}

}
