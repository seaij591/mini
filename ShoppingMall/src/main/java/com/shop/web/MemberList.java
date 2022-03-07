package com.shop.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.member.service.MemberService;
import com.shop.member.serviceImpl.MemberServiceImpl;

public class MemberList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberDao = new MemberServiceImpl(); //member Table에 접근하기 위해 Dao 생성
		request.setAttribute("members", memberDao.selectMemberList()); //멤버리스트를 실행하여 결과를 담음
		return "memberlist/memberList.tiles";
	}

}
