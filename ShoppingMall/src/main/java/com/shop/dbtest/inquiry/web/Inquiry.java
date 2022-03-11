package com.shop.dbtest.inquiry.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.dbtest.inquiry.serviceImpl.InquiryServiceImpl;
import com.shop.dbtest.inquiry.vo.InquiryVO;

public class Inquiry implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//내용보기
		InquiryServiceImpl dao = new InquiryServiceImpl();
		InquiryVO vo = new InquiryVO();
		
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		vo = dao.inquirySelect(vo);
		request.setAttribute("vo", vo);
		return "inquiry/inquiry.tiles";
	}

}
