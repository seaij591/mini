package com.shop.dbtest.notice.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.dbtest.notice.serviceImpl.NoticeServiceImpl;
import com.shop.dbtest.notice.vo.NoticeVO;

public class NoticeList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 공지사항 전체보기
		NoticeServiceImpl dao = new NoticeServiceImpl();
		List<NoticeVO> list = new ArrayList<NoticeVO>();

		list = dao.noticeSelectList();
		request.setAttribute("notices", list);

		return "notice/noticeList.tiles";
	}

}
