package com.exceptions;

public class FileDoesNotExistException extends Exception{

	public FileDoesNotExistException(String message) {
		super(message);
		System.out.println(message);
	}
	
}
