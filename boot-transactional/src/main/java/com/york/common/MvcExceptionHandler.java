package com.york.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@ControllerAdvice
public class MvcExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(MvcExceptionHandler.class);


	@ExceptionHandler
	public @ResponseBody
    Object handleException(MethodArgumentNotValidException e, HttpServletResponse response) {
		List<ObjectError> objectErrors = e.getBindingResult().getAllErrors();
		StringBuilder sb = new StringBuilder();
		for (ObjectError error : objectErrors) {
			sb.append("[").append(error.getDefaultMessage()).append("] ");
		}
		LOGGER.error(e.getMessage(), e);
		response.setStatus(ResponseJson.SC_CLIENT_ERROR);
		return ResponseJson.parameterError(sb.toString());
	}



	@ExceptionHandler
	public @ResponseBody
    Object handleException(IllegalArgumentException e, HttpServletResponse response) {
		LOGGER.error(e.getMessage(), e);
		response.setStatus(ResponseJson.SC_CLIENT_ERROR);
		return ResponseJson.parameterError("非法参数+" + e.getMessage());
	}




	@ExceptionHandler
	public @ResponseBody
    Object handleException(Exception e, HttpServletResponse response) {
		LOGGER.error(e.getMessage(), e);
		if(e instanceof BusinessException){
			response.setStatus(ResponseJson.SC_SERVER_ERROR);
			return ResponseJson.serverError(e.getMessage());
		}
		response.setStatus(ResponseJson.SC_SERVER_ERROR);
		return ResponseJson.serverError();
	}



}
