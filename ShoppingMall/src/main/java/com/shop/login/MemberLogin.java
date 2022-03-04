package com.shop.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.DbCommand;
import com.shop.member.service.MemberService;
import com.shop.member.serviceImpl.MemberServiceImpl;
import com.shop.member.vo.MemberVO;



public class MemberLogin implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그인 처리 과정
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();  //세션객체에 서버가 가지고 있는 세션객체를 담는다
		
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		vo = dao.loginCheck(vo);
		request.setAttribute("member", vo);
		String viewPage;
		if(vo.getMemberName() != null) {
			session.setAttribute("id", vo.getMemberId());  //세션에 id란 변수로 멤버아이디를 저장
			session.setAttribute("name", vo.getMemberName()); // 세션에 name란 변수로 멤버이름 저장
			viewPage = "login/memberLoginSuccess.tiles";
		} else {
			viewPage = "login/memberLoginFail.tiles";
		}
		return viewPage;
	}

}

