package com.york.boot.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 无返回值得异步模型
 * @Author: York.Hwang
 * @Date: 2019/12/22 00:55
 */
@Service
public class AsyncNoReturnsService {

    private static long SLEEP_SEC = 3L;


    @Async
    public void asyncNoReturns(){
        long startTime = System.currentTimeMillis();
        try {
            TimeUnit.SECONDS.sleep(SLEEP_SEC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long costMills = System.currentTimeMillis() - startTime;
        System.out.println("asyncNoReturns=====执行完成====花费"+costMills+"毫秒");
    }

}
