package com.shop.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;

public class Shop implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	
		return "shopinfo/shopmain.tiles";
	}

}
