package com.york.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description: 打印日志切面
 * @Author: York.Hwang
 * @Date: 2020/2/7 12:41
 */
@Aspect
@Component
public class LogCostTimeAop {
    final static Logger LOG = LoggerFactory.getLogger(LogCostTimeAop.class);

    @Value("${log.cost.time.enable:true}")
    private boolean logCostTimeEnable;


    @Pointcut("@annotation(com.york.common.annotation.LogCostTime)")
    public void costTimePointCut(){

    }

    @Around("costTimePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        //判断开关
        if(!logCostTimeEnable){
           return point.proceed();
        }
        //记录开始时间
        long startTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - startTime;
        logCostTime(point, time);
        return result;
    }

    private void logCostTime(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = joinPoint.getTarget().getClass().getName();
        LOG.info("{}.{} cost:{}ms", className, signature.getName(), time);
    }

}
