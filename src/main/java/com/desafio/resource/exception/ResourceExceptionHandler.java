package com.desafio.resource.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.desafio.service.exception.DataIntegrityException;
import com.desafio.service.exception.NotFoundResourceException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(NotFoundResourceException.class)
	public ResponseEntity<StandardError> notFoundResource(NotFoundResourceException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		String error = "Erro na requisição.";
		StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataSourceViolation(DataIntegrityException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String error = "Violação de Integridade";
		StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
