package com.exceptions;

public class InvalidFileNameException extends Exception{

	public InvalidFileNameException(String message) {
		super(message);
		System.out.println(message);
	}
	
}
