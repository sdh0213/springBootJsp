package com.example.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.common.BizException;
import com.example.common.CustomAuthException;

@ControllerAdvice
@RequestMapping("/error")
@Controller
public class ExceptionHandlingController {
	
	static final Logger log = LoggerFactory.getLogger(ExceptionHandlingController.class);
	/** Global Exception
	 * ErrorPagesController  */
//	@ExceptionHandler(value = Exception.class)
//	@ResponseBody
//	public ModelAndView LoginAuthError(HttpServletRequest req, Exception exception){
//		ModelAndView mav=new ModelAndView();
//		mav.addObject("exception",exception);
//		mav.addObject("url",req.getRequestURL());
//		mav.setViewName("error/500"); 
//		return mav;
//	} 
	
	/** custom Exception ó�� */

	@ExceptionHandler(value = CustomAuthException.class)
	@ResponseBody
	public ModelAndView LoginAuthError(HttpServletRequest req, CustomAuthException exception){
		ModelAndView mav=new ModelAndView();
		mav.addObject("exception",exception);
		mav.addObject("url",req.getRequestURL());
		mav.setViewName("error/loginAuthError"); 
		return mav;
	} 
	
	/** bizException */
	@ExceptionHandler(value = BizException.class)
	@ResponseBody
	public ModelAndView LoginAuthError(HttpServletRequest req, BizException exception){
		ModelAndView mav=new ModelAndView();
		mav.addObject("exception",exception);
		mav.addObject("errCode",exception.getErrCode());
		mav.addObject("url",req.getRequestURL());
		mav.setViewName("error/bizError"); 
		return mav;
	} 
}
