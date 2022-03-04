package com.shop.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.member.serviceImpl.MemberServiceImpl;

public class idCheck implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 아이디 중복 체크
		MemberServiceImpl member = new MemberServiceImpl();
		String id = request.getParameter("id");
		boolean check = member.idCheck(id);
		//true 면 존재, false면 사용가능
		String msg;
		if(!check) 
			msg = "사용가능한 아이디 입니다.";
		else
			msg = "이미존재하는 아이디 입니다.";
		
		request.setAttribute("msg", msg);
		request.setAttribute("check", check);
		request.setAttribute("id", id);
		return "login/memberIdCheck.tiles";
	}

}
