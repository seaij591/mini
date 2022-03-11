package com.shop.dbtest.cart.vo;

public class CartVO {
	private String member_id;
	private String pd_id;
	private int pd_quantity;
	private String pd_color;
	private String pd_size;
	
	public CartVO() {
		
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

	
	

}
