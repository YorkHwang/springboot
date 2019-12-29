package com.york.common;


import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

@Component
public class ResponseHandler implements HandlerInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(ResponseHandler.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 302不做处理
		if (response.getStatus() == HttpStatus.FOUND.value()) {
			return;
		}
		// 401不做处理
		if (response.getStatus() == HttpStatus.UNAUTHORIZED.value()) {
			return;
		}
		// 403不做处理
		if (response.getStatus() == HttpStatus.FORBIDDEN.value()) {
			return;
		}

		// 出错的情况下,处理消息
		if (response.getStatus() != HttpStatus.OK.value()) {
			if (response instanceof ContentCachingResponseWrapper) {
				ContentCachingResponseWrapper responseWrapper = (ContentCachingResponseWrapper) response;
				String json = new String(responseWrapper.getContentAsByteArray(), StandardCharsets.UTF_8);
				responseJSON(response, json);
			}
			return;
		}

		//正常情况下
		Collection<String> headerNames = response.getHeaderNames();
		// 文件下载  swagger 图片预览 不做处理
		if (headerNames.contains("Content-Disposition")
				|| headerNames.contains("Transfer-Encoding")
				|| (response.getContentType() != null && response.getContentType().startsWith("image"))) {
			return;
		}

		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Class<?> returnType = handlerMethod.getMethod().getReturnType();

		// controller返回void
		if (returnType.getName().equals("void")) {
			responseJSON(response, JSON.toJSONString(ResponseJson.success(null)));
		}
	}


	public void responseJSON(HttpServletResponse response, String json) {
		PrintWriter pw = null;
		try {
			response.resetBuffer();
			response.setStatus(200);
			response.setBufferSize(json.length());
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			pw = response.getWriter();
			pw.write(json);
			pw.flush();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			if(pw != null){
				pw.close();
			}
		}
	}

}
