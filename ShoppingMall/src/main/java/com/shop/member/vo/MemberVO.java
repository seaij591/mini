package com.shop.member.vo;

public class MemberVO {
	private String memberId;
	private String memberName;
	private String memberPassword;
	private String memberAddress;
	private String memberTel;
	private String findId;
	private String findPw;
	
	
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}

	
	public String getMemberTel() {
		return memberTel;
	}


	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}


	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}


	public String getFindId() {
		return findId;
	}


	public void setFindId(String findId) {
		this.findId = findId;
	}


	public String getFindPw() {
		return findPw;
	}


	public void setFindPw(String findPw) {
		this.findPw = findPw;
	}
	
	
}
