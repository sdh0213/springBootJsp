package com.example.common;

public class CustomAuthException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomAuthException(String message){
		super(message);
	}
}
