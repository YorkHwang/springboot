package com.york;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


/**
 *  @Description：启动主类
 *  @Author: York.Hwang
 *  @Date: 2019/12/29 11:55
 */
@SpringBootApplication
@MapperScan("com.york.dao.mapper")
public class BootTransactionalApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(BootTransactionalApp.class);
    }
}
