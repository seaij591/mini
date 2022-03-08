package com.shop.find;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.member.serviceImpl.MemberServiceImpl;

public class FindIdResult implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 아이디 찾기
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String member_name = request.getParameter("member_name");
		String member_tel = request.getParameter("member_tel");

		MemberServiceImpl vo = new MemberServiceImpl();
		String member_id = vo.findId(member_name, member_tel);

		request.setAttribute("id", member_id);
		return "find/findIdResult.tiles";
	}

}
