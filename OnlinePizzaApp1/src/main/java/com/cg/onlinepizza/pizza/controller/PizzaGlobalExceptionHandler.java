package com.cg.onlinepizza.pizza.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cg.onlinepizza.pizza.exception.InvalidMinCostException;
import com.cg.onlinepizza.pizza.exception.PizzaErrorInformation;
import com.cg.onlinepizza.pizza.exception.PizzaIdNotFoundException;

@ControllerAdvice
@RequestMapping("/PizzaApp")
public class PizzaGlobalExceptionHandler {

	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ResponseBody
	@ExceptionHandler(value= {PizzaIdNotFoundException.class,InvalidMinCostException.class})
	public PizzaErrorInformation handleConflict(Exception ex,HttpServletRequest req) {
		return new PizzaErrorInformation(ex.getMessage(),req.getRequestURI(),LocalDateTime.now().toString());
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	@ExceptionHandler(value= {Exception.class})
	public PizzaErrorInformation handleError(Exception ex,HttpServletRequest req) {
		return new PizzaErrorInformation(ex.getMessage(),req.getRequestURI(),LocalDateTime.now().toString());
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	public PizzaErrorInformation handleValidationError(MethodArgumentNotValidException ex, HttpServletRequest req) {
	String msg = "validation faild";
	FieldError error = ex.getFieldError();
	if(error != null)
		msg = error.getDefaultMessage();
	return new PizzaErrorInformation(msg, req.getRequestURI(),LocalDateTime.now().toString());

	}
}
