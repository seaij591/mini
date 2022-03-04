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
import com.shop.web.About;
import com.shop.web.Shop;

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
		map.put("/shop.do", new Shop()); //shop 정보
		
		
		//커뮤니티
		map.put("/support.do", new support()); // 고객지원센터 페이지
		map.put("/inquiry.do", new inquiry()); // 문의 게시판
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
