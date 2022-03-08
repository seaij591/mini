package com.shop.product.vo;

public class ProductVO {
	private String pdId;
	private String pdCategory;
	private String pdName;
	private String pdSize;
	private String pdColor;
	private String pdPrice;
	private String pdImage1;
	private String pdImage2;
	private String pdImage3;
	private String pdContent;

	public String getPdId() {
		return pdId;
	}

	public void setPdId(String pdId) {
		this.pdId = pdId;
	}

	public String getPdCategory() {
		return pdCategory;
	}

	public void setPdCategory(String pdCategory) {
		this.pdCategory = pdCategory;
	}

	public String getPdName() {
		return pdName;
	}

	public void setPdName(String pdName) {
		this.pdName = pdName;
	}

	public String getPdSize() {
		return pdSize;
	}

	public void setPdSize(String pdSize) {
		this.pdSize = pdSize;
	}

	public String getPdColor() {
		return pdColor;
	}

	public void setPdColor(String pdColor) {
		this.pdColor = pdColor;
	}

	public String getPdPrice() {
		return pdPrice;
	}

	public void setPdPrice(String pdPrice) {
		this.pdPrice = pdPrice;
	}

	public String getPdImage1() {
		return pdImage1;
	}

	public void setPdImage1(String pdImage1) {
		this.pdImage1 = pdImage1;
	}

	public String getPdImage2() {
		return pdImage2;
	}

	public void setPdImage2(String pdImage2) {
		this.pdImage2 = pdImage2;
	}

	public String getPdImage3() {
		return pdImage3;
	}

	public void setPdImage3(String pdImage3) {
		this.pdImage3 = pdImage3;
	}

	public String getPdContent() {
		return pdContent;
	}

	public void setPdContent(String pdContent) {
		this.pdContent = pdContent;
	}

	@Override
	public String toString() {
		return "ProductVO [pdId=" + pdId + ", pdCategory=" + pdCategory + ", pdName=" + pdName + ", pdSize=" + pdSize
				+ ", pdColor=" + pdColor + ", pdPrice=" + pdPrice + ", pdImage1=" + pdImage1 + ", pdImage2=" + pdImage2
				+ ", pdImage3=" + pdImage3 + ", pdContent=" + pdContent + "]";
	}

}
