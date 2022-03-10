package com.shop.find;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.member.serviceImpl.MemberServiceImpl;

public class FindId implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 아이디찾기 폼 출력

		return "find/findId.tiles";
	}

}
