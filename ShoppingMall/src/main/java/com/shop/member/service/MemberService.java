package com.shop.member.service;

import java.util.List;

import com.shop.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> selectMemberList();
	MemberVO selectMember(MemberVO vo);
	public int insertMember(MemberVO vo);
	public int updateMember(MemberVO vo);
	public int deleteMember(MemberVO vo);
	public MemberVO loginCheck(MemberVO vo);
	public MemberVO findId(MemberVO vo);
}