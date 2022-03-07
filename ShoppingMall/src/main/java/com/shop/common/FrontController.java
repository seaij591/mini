package com.shop.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.community.inquiry;
import com.shop.community.support;

import com.shop.dbtest.notice.web.Notice;
import com.shop.dbtest.notice.web.NoticeForm;
import com.shop.dbtest.notice.web.NoticeList;
import com.shop.dbtest.notice.web.NoticeListPaging;
import com.shop.dbtest.notice.web.NoticeWrite;

import com.shop.login.Signup;
import com.shop.login.MemberLogin;
import com.shop.web.About;
import com.shop.web.MemberLogOut;
import com.shop.web.Shop;
import com.shop.web.idCheck;
import com.shop.web.memberJoin;

import co.micol.dbtest.member.web.MemberLoginOut;

//@WebServlet("/FrontController")
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private HashMap<String, DbCommand> map = new HashMap<String, DbCommand>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO 호출명 저장소
		map.put("/main.do", new MainPage()); // 시작페이지
		map.put("/about.do", new About()); // 회사소개
		map.put("/shop.do", new Shop()); // shop 정보

		// 커뮤니티
		map.put("/support.do", new support()); // 고객지원센터 페이지
		map.put("/inquiry.do", new inquiry()); // 문의 게시판

		map.put("/noticeList.do", new NoticeList()); // 공지사항 목록
		map.put("/noticeListPaging.do", new NoticeListPaging()); // 공지사항 목록
		map.put("/notice.do", new Notice()); // 공지사항 내용보기
		map.put("/noticeForm.do", new NoticeForm()); // 공지사항 등록 폼 호출
		map.put("/noticeWrite.do", new NoticeWrite()); // 공지사항 저장

		map.put("/login.do", new Login()); // 로그인폼 호출
		map.put("/memberLogin.do", new MemberLogin());// 로그인처리
		// 로그아웃 처리
		map.put("/signup.do", new Signup()); // 회원가입폼 호출
		map.put("/idCheck.do", new idCheck());// 아이디 중복 체크
		map.put("/memberJoin.do", new memberJoin()); // 회원가입 처리
		map.put("/memberLogOut.do", new MemberLogOut()); // 로그아웃 처리

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO 실제처리할 command를 호출하고, 결과를 돌려줄 페이지를 작성하는 곳
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());

		DbCommand dbCommand = map.get(path);
		String viewPage = dbCommand.execute(request, response);

		if (viewPage != null) {
			// ajax 응답
			if (viewPage.startsWith("ajax:")) {
				response.setContentType("text/plain; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}

			// 뷰페이지 포워드
			if (viewPage.endsWith(".jsp"))
				viewPage = "WEB-INF/jsp/" + viewPage;

			System.out.println(viewPage);
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}

}
