package com.meli.melitest.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.meli.melitest.controller.exception.BadFormatException;
import com.meli.melitest.exception.data.StandardError;

import lombok.RequiredArgsConstructor;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionResourceHandler {

	@ExceptionHandler(BadFormatException.class)
	public ResponseEntity<StandardError> badFormatException(BadFormatException e, HttpServletRequest request) {

		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

		StandardError error = new StandardError(System.currentTimeMillis(), httpStatus.value(), "Invalid URL",
				e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(httpStatus).body(error);
	}

}
