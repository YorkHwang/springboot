package com.york.boot.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 商品service
 * @Author: York.Hwang
 * @Date: 2019/12/22 01:06
 */
@Service
public class GoodsService {

    private static long SLEEP_SEC = 1L;

    public int getCommentsCount(){
        //模拟DB或者其他系统查询结果等待时间
        sleep();
        return 1000;
    }

    public int getSalesCount(){
        sleep();
        return 1001;
    }

    public int getCollectsCount(){
        sleep();
        return 1003;
    }


    private void sleep() {
        //模拟DB或者其他系统查询结果等待时间
        try {
            TimeUnit.SECONDS.sleep(SLEEP_SEC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Async()
    public Future<Integer> getCommentsCountAsync(){
        //模拟DB或者其他系统查询结果等待时间
        sleep();
        System.out.println("异步查询评论数线程的名称："+Thread.currentThread().getName());
        return new AsyncResult<>(1000);
    }

    @Async("asyncExecutor2")
    public Future<Integer>  getSalesCountAsync(){
        sleep();
        System.out.println("异步查询销量线程的名称："+Thread.currentThread().getName());
        return new AsyncResult<>(1001);
    }

    @Async("asyncExecutor")
    public Future<Integer> getCollectsCountAsync(){
        sleep();
        System.out.println("异步查询收藏数线程的名称："+Thread.currentThread().getName());
        return new AsyncResult<>(1003);
    }


    public Future<Integer> getCollectsCountAsync2(){
       return getCollectsCountAsync();
    }


}
