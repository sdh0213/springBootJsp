package com.example.member.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.common.AbstractDAO;
import com.example.member.vo.MemberVO;

@Repository("MemberMapper")
public class MemberMapper extends AbstractDAO{
	@SuppressWarnings("unchecked")
	public List<MemberVO> selectMemberList(){
	List<MemberVO> resultList = selectList("SampleMapper.selectMemberList"); 
	return resultList; 
	}
	
	public int insertMember(MemberVO mv){
		return (Integer) insert("SampleMapper.insertMember", mv);
	}
	
	public int updateMember(MemberVO mv){
		return (Integer) update("SampleMapper.updateMember", mv);
	}
}
