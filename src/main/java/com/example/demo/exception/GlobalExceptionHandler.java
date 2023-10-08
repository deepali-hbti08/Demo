package com.example.demo.exception;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.model.Response;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value= {StudentNotFoundException.class})
	public ResponseEntity<Object> handleStudentException(StudentNotFoundException e) {
		//Response res=Response.buildFail(e.getCode(),e.getMsg());
		Response res=new Response();
		if(Objects.nonNull(e.getError()))
			res=Response.buildFail(e.getError());
		else
			res=Response.buildFail(e.getCode(),e.getMsg());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
	}
	
	@ExceptionHandler(value= {NullPointerException.class})
	public ResponseEntity<Object> handleNullPointerException(NullPointerException e) {
		Response res = new Response();
		res=Response.buildFail("300",e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
	}
}
