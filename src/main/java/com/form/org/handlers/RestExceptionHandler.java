package com.form.org.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.InvalidEntityException;



@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

@ExceptionHandler(EntityNotFoundException.class)
public ResponseEntity<ErrorDto> handleException(EntityNotFoundException exception, WebRequest webReq)
{
	final HttpStatus notFound= HttpStatus.NOT_FOUND;
	
	final ErrorDto errerDto= ErrorDto.builder()
	.code(exception.getErrorCode())
	.httpcode(notFound.value())
	.message(exception.getMessage())
	.build();
	
	return new ResponseEntity<>(errerDto,notFound);
		
	}

@ExceptionHandler(InvalidEntityException.class)
public ResponseEntity<ErrorDto>handleException(InvalidEntityException exception , WebRequest webReq){
	
	final HttpStatus badReuqest =HttpStatus.NOT_FOUND;
	
	final ErrorDto errerDto= ErrorDto.builder()
	.code(exception.getErrorCode())
	.httpcode(badReuqest.value())
	.message(exception.getMessage())
	.errors(exception.getErrors())
	.build();
	
	return new ResponseEntity<>(errerDto, badReuqest);
	
	
}
		
	
}