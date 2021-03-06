package com.shop.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.community.support;

import com.shop.dbtest.cart.web.CartCheckFail;
import com.shop.dbtest.cart.web.CartInsert;

import com.shop.dbtest.inquiry.web.Inquiry;
import com.shop.dbtest.inquiry.web.InquiryForm;
import com.shop.dbtest.inquiry.web.InquiryList;
import com.shop.dbtest.inquiry.web.InquiryWrite;

import com.shop.dbtest.cart.web.CartList;
import com.shop.dbtest.notice.web.Notice;
import com.shop.dbtest.notice.web.NoticeForm;
import com.shop.dbtest.notice.web.NoticeList;
import com.shop.dbtest.notice.web.NoticeListPaging;
import com.shop.dbtest.notice.web.NoticeWrite;
import com.shop.dbtest.search.SearchProduct;
import com.shop.find.FindId;
import com.shop.find.FindIdResult;
import com.shop.find.FindPw;
import com.shop.find.FindPwResult;
import com.shop.login.MemberLogin;
import com.shop.login.Signup;
import com.shop.product.ProductForm;
import com.shop.product.ProductInsert;
import com.shop.product.ProductInsertForm;
import com.shop.product.ProductSelect;
import com.shop.web.About;
import com.shop.web.IdCheck;
import com.shop.web.MemberJoin;
import com.shop.web.MemberList;
import com.shop.web.MemberLogOut;
import com.shop.web.Search;
import com.shop.web.Shop;
import com.shop.web.Shopdetails;



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

		// 커뮤니티
		map.put("/support.do", new support()); // 고객지원센터 페이지
		// 문의게시판
		map.put("/inquiryList.do", new InquiryList()); // 문의 게시판
		map.put("/inquiryForm.do", new InquiryForm()); // 문의 등록 폼
		map.put("/inquiryWrite.do", new InquiryWrite()); // 문의 저장
		map.put("/inquiry.do", new Inquiry()); // 문의 내용보기
		
		// 공지사항
		map.put("/noticeList.do", new NoticeList()); // 공지사항 목록
		map.put("/noticeListPaging.do", new NoticeListPaging()); // 공지사항 목록
		map.put("/notice.do", new Notice()); // 공지사항 내용보기
		map.put("/noticeForm.do", new NoticeForm()); // 공지사항 등록 폼 호출
		map.put("/noticeWrite.do", new NoticeWrite()); // 공지사항 저장
		
		//로그인
		map.put("/login.do", new Login()); // 로그인폼 호출
		map.put("/memberLogin.do", new MemberLogin());// 로그인처리
		map.put("/signup.do", new Signup()); // 회원가입폼 호출
		map.put("/idCheck.do", new IdCheck());// 아이디 중복 체크
		map.put("/memberJoin.do", new MemberJoin()); // 회원가입 처리
		map.put("/memberLogOut.do", new MemberLogOut()); // 로그아웃 처리
		map.put("/findId.do", new FindId()); //아이디 조회폼
		map.put("/findIdResult.do", new FindIdResult()); //아이디 조회 후 출력
		map.put("/findPw.do", new FindPw()); // 비밀번호 조회 폼
		map.put("/findPwResult.do", new FindPwResult()); //비밀번호 조회 후 출력
		//관리자
		map.put("/productForm.do", new ProductForm()); //상품 리스트조회폼
		map.put("/productInsertForm.do", new ProductInsertForm()); //상품등록 폼
		map.put("/memberList.do", new MemberList()); //회원 리스트 출력
		
		//상품등록
		map.put("/productInsert.do", new ProductInsert()); //등록
		map.put("/productSelect.do", new ProductSelect()); //조회
		//map.put("/bulletinUpdate.do", new BulletinUpdate()); //수정
		//map.put("/bulletinDelete.do", new BulletinDelete()); //삭제
		
		map.put("/searchProduct.do", new SearchProduct()); //상품검색기능
		map.put("/cartList.do", new CartList()); //장바구니 페이지
		map.put("/cartInsert.do", new CartInsert());//장바구니 추가
		map.put("/cartCheckFail.do", new CartCheckFail());//장바구니 추가 시 같은 상품이 있을 때 돌아가기
		
		
		//상품정보
		map.put("/shop.do", new Shop()); // shop 정보
		map.put("/shopdetails.do", new Shopdetails()); //상품 상세정보
		
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
