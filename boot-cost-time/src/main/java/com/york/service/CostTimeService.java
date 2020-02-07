package com.york.service;

import com.york.common.annotation.LogCostTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: York.Hwang
 * @Date: 2020/2/7 12:24
 */
@Service
public class CostTimeService {

    Logger logger = LoggerFactory.getLogger(getClass());


    @LogCostTime
    public String costTime() throws InterruptedException {
        long st = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(3L);
        ((CostTimeService) AopContext.currentProxy()).exe();
        String result  = "=====costTime costTime=="+(System.currentTimeMillis()-st);
        logger.info(result);
        return result;
    }

    @LogCostTime
    public void exe() throws InterruptedException {
        long st = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(1L);
        String result  = "=====exe costTime=="+(System.currentTimeMillis()-st);
        logger.info(result);
    }

}
