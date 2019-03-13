package com.example.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BizException extends Exception{
	//�����
	static final Logger log = LoggerFactory.getLogger(BizException.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String errCode;
	String errMassage;
	
	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMassage() {
		return errMassage;
	}

	public void setErrMassage(String errMassage) {
		this.errMassage = errMassage;
	}

	public BizException(String errCode, String errMassage){
		super(errMassage);
		this.errCode = errCode;
		this.errMassage = errMassage;
		
		log.debug("Exception :"+ errCode+"  "+"errMassage : "+errMassage);
	}
}
