package com.meli.melitest.controller.exception;

public class BadFormatException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BadFormatException(String errorMessage) {
		super(errorMessage);
	}
}
