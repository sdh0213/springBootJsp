package com.example.member.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.common.CustomAuthException;
import com.example.member.service.impl.MemberServiceImpl;
import com.example.member.vo.MemberVO;


@Controller
public class MemberController {
	//선언부
	static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
    @Autowired
    MemberServiceImpl memberservice;
    
    @RequestMapping(value="/selectMember")
    @ResponseBody
    public ModelAndView selectMember() throws Exception,CustomAuthException{

        ModelAndView mv = new ModelAndView();
        
        List<MemberVO> listTest = memberservice.selectMemberList();
        
//        if(mv != null) {
//    		throw new BizException("B0001","biz 익셉션 발생!!");
//    	}
        
//        if(mv == null) {
//    		throw new CustomAuthException("로그인이 필요한 서비스 입니다!");
//    	}
        
        mv.addObject("listTest",listTest);      // jstl로 호출
        mv.addObject("ObjectTest","테스트입니다."); // jstl로 호출
        mv.setViewName("dbSelect");         
        
        return mv;
    }
    
    @RequestMapping(value="/insertMember")
    public ModelAndView insertMember(MemberVO mv) throws Exception{
        
    	System.out.print("insert 시작!");
    	mv.setCode("A00010");
    	mv.setName("park0010");
    	mv.setTeam("COE0010");
    	
    	int i= memberservice.insertMember(mv);
    	System.out.println("======= i :"+ i );
        
        ModelAndView mav= new ModelAndView();
        
        List<MemberVO> listTest = memberservice.selectMemberList();
        
        mav.addObject("listTest",listTest);      // jstl로 호출
        mav.setViewName("dbSelect");
        
        return mav;
    }
    
    @RequestMapping(value="/updateMember")
    public ModelAndView updateMember(MemberVO mv) throws Exception{
        System.out.print("insert 시작!");
        mv.setCode("A0005");
        mv.setName("parksin");
        mv.setTeam("COE1");
        
        int i= memberservice.updateMember(mv);
        System.out.println("======= i :"+ i );
        
        ModelAndView mav= new ModelAndView();
        
        List<MemberVO> listTest = memberservice.selectMemberList();
        
        mav.addObject("listTest",listTest);      // jstl로 호출
        mav.setViewName("dbSelect");
        
        return mav;
    }
    
    
    @RequestMapping(value="/mv")                // http://localhost/mv
    public ModelAndView root() {
    	log.debug("vm 시작");
        ModelAndView mv = new ModelAndView();
         
        List<String> listTest = new ArrayList<String>();
         
        listTest.add("test1");
        listTest.add("test2");
        listTest.add("test3");
         
        mv.addObject("listTest",listTest);      // jstl로 호출
        mv.addObject("ObjectTest","테스트입니다."); // jstl로 호출
        mv.setViewName("testMv");         // 실제 호출될 /WEB-INF/jsp/model/testMv.jsp
        
        return mv;               
    }
    
    @RequestMapping(value="/mv/testMv")                // http://localhost/mv
    public ModelAndView testMv() {
    	System.out.println("vm 시작");
        ModelAndView mv = new ModelAndView();
         
        List<String> listTest = new ArrayList<String>();
         
        listTest.add("test1");
        listTest.add("test2");
        listTest.add("test3");
        
        String aa = "테스트 짱짱짱!!!";
        
        mv.addObject("listTest",listTest);      // jstl로 호출
        mv.addObject("ObjectTest",aa); // jstl로 호출
        mv.setViewName("mv/testMv");         // 실제 호출될 /WEB-INF/jsp/model/testMv.jsp
        return mv;               
    }
    
    @RequestMapping(value="/demo")
    //@ResponseBody
    public String demo() throws Exception{
        System.out.print("demo startto!");
        
        return "demo";
    }
    /** 반환 값으로 지정하여 이동처로 "forward:"를 붙이면 다른 컨트롤러 메소드로 이동한다. */
    @RequestMapping("/forward1")
    public String forward1() {
        return "forward:method1";
    }
    
    /** 리다이렉트하려면 "redirect:"를 붙인다.*/
    @RequestMapping("/redirect1")
    public String redirect1() {
        return "redirect:method1";
    }

    /** 외부 URL을 지정하는 경우도 있다.*/
    @RequestMapping("/redirect2")
    public String redirect2() {
        return "redirect:https://www.google.co.jp/";
    }
    
    @RequestMapping("/json") 
    @ResponseBody
	 public Map<String, String> jsonReturnSample(){
        Map<String, String> map = new HashMap<>();
        map.put("name", "111");
        map.put("age", "2222");
        return map;
    }

  

    
}
