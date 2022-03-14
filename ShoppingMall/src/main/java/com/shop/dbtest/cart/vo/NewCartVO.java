package com.shop.dbtest.cart.vo;

public class NewCartVO {
	private String member_id;
	private String pd_id;
	private String pd_name;
	private int pd_price;
	private int pd_quantity;
	private String pd_color;
	private String pd_size;
	private String pd_image1;
	

	public NewCartVO() {
		
	}
	
	

	public String getPd_image1() {
		return pd_image1;
	}



	public void setPd_image1(String pd_image1) {
		this.pd_image1 = pd_image1;
	}



	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getPd_id() {
		return pd_id;
	}

	public void setPd_id(String pd_id) {
		this.pd_id = pd_id;
	}

	public String getPd_name() {
		return pd_name;
	}

	public void setPd_name(String pd_name) {
		this.pd_name = pd_name;
	}

	public int getPd_price() {
		return pd_price;
	}

	public void setPd_price(int pd_price) {
		this.pd_price = pd_price;
	}

	public int getPd_quantity() {
		return pd_quantity;
	}

	public void setPd_quantity(int pd_quantity) {
		this.pd_quantity = pd_quantity;
	}

	public String getPd_color() {
		return pd_color;
	}

	public void setPd_color(String pd_color) {
		this.pd_color = pd_color;
	}

	public String getPd_size() {
		return pd_size;
	}

	public void setPd_size(String pd_size) {
		this.pd_size = pd_size;
	}
	
	
}
