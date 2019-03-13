package com.example.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.member.mapper.MemberMapper;
import com.example.member.vo.MemberVO;

@Transactional
@Service
public class MemberServiceImpl {
	@Autowired
	MemberMapper memberMapper;
	
	public List<MemberVO> selectMemberList() throws Exception{
		List<MemberVO>  resultList = memberMapper.selectMemberList(); 
		return resultList;
	}
	
	public int insertMember(MemberVO mv){
		return memberMapper.insertMember(mv);
	}
	
	public int updateMember(MemberVO mv){
		return memberMapper.updateMember(mv);
	}
}
