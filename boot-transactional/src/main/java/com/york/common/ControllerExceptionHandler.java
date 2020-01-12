package com.york.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *  @Description:统一异常处理类
 *  @Author: York.Hwang
 *  @Date: 2020/1/11 22:40
 */
@ControllerAdvice
public class ControllerExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);

	/**
	 *  @Description:业务异常
	 */
	@ExceptionHandler
	public @ResponseBody
	Object handleException(BusinessException e, HttpServletResponse response) {
		LOGGER.error(e.getMessage(), e);
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return ResponseJson.serverError();
	}


	/**
	 *  @Description:参数绑定时异常
	 */
	@ExceptionHandler
	@ResponseBody
    public Object handleException(MethodArgumentNotValidException e, HttpServletResponse response) {
		List<ObjectError> objectErrors = e.getBindingResult().getAllErrors();
		StringBuilder sb = new StringBuilder();
		for (ObjectError error : objectErrors) {
			sb.append("[").append(error.getDefaultMessage()).append("] ");
		}
		LOGGER.error(e.getMessage(), e);
		response.setStatus(ResponseJson.SC_CLIENT_ERROR);
		return ResponseJson.parameterError(sb.toString());
	}


	/**
	 *  @Description:参数异常
	 */
	@ExceptionHandler
	public @ResponseBody
    Object handleException(IllegalArgumentException e, HttpServletResponse response) {
		LOGGER.error(e.getMessage(), e);
		response.setStatus(ResponseJson.SC_CLIENT_ERROR);
		return ResponseJson.parameterError("非法参数+" + e.getMessage());
	}



	/**
	 *  @Description:其他所有异常
	 */
	@ExceptionHandler
	public @ResponseBody
    Object handleException(Throwable e, HttpServletResponse response) {
		LOGGER.error(e.getMessage(), e);
		if(e instanceof BusinessException){
			response.setStatus(ResponseJson.SC_SERVER_ERROR);
			return ResponseJson.serverError(e.getMessage());
		}
		response.setStatus(ResponseJson.SC_SERVER_ERROR);
		return ResponseJson.serverError();
	}



}
