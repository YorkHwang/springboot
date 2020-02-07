package com.york;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *  @Description: 启动类
 *  @Author: York.Hwang
 *  @Date: 2020/2/7 12:19
 */
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class BootCostTime
{
    public static void main( String[] args )
    {
        SpringApplication.run(BootCostTime.class);
    }

}
