package com.york.common.annotation;

import java.lang.annotation.*;

/**
 * @Description: 日志记录花费时间注解
 * @Author: York.Hwang
 * @Date: 2020/2/7 12:39
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogCostTime {

}
