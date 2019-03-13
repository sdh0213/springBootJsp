package com.example.member.service;

import java.util.List;

import com.example.member.vo.MemberVO;

public interface MemberService {
	public List<MemberVO> selectMemberList() throws Exception;
	public int insertMember() throws Exception;
	public int updateMember() throws Exception;
}
