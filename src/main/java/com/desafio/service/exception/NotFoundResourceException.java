package com.desafio.service.exception;

public class NotFoundResourceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public NotFoundResourceException(String msg) {
		super(msg);
	}
	

}
