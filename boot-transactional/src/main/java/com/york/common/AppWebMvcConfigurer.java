package com.york.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @Description:拦截器
 * @Author: York.Hwang
 * @Date: 2019/12/28 23:55
 */
@SpringBootConfiguration
public class AppWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    ResponseHandler responseHandler;

    /**
     * 加入拦截
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(responseHandler).addPathPatterns("/**");
    }



}
