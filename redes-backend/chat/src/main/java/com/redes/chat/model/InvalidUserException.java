package com.redes.chat.model;

@SuppressWarnings("serial")
public class InvalidUserException extends RuntimeException {
	
	public InvalidUserException(String message) {
		super(message);
	}
}