package com.york.boot.async.controller;

import com.york.boot.async.service.AsyncNoReturnsService;
import com.york.boot.async.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Description: 异步测试的控制器
 * @Author: York.Hwang
 * @Date: 2019/12/22 00:53
 */
@RequestMapping("/")
@RestController()
public class AsyncController {

    @Autowired
    AsyncNoReturnsService asyncNoReturnsService;

    @Autowired
    GoodsService goodsService;


    @RequestMapping("/async/noReturns")
    public String asyncNoReturnsRequest(){
        long startTime = System.currentTimeMillis();
        asyncNoReturnsService.asyncNoReturns();
        long costTime = System.currentTimeMillis()-startTime;
        return "asyncNoReturnsRequest=====执行完成====花费"+costTime+"毫秒";
    }


    @RequestMapping("/sync/goods/info")
    public String syncGoodsInfo(){
        long startTime = System.currentTimeMillis();
        int collectsCount = goodsService.getCollectsCount();
        int commentsCount= goodsService.getCommentsCount();
        int salesCount= goodsService.getSalesCount();
        long costTime = System.currentTimeMillis()-startTime;
        return String.format("同步查询商品信息=收藏数%d==评论数%d==销量%d 执行完成====花费%d毫秒"
                ,collectsCount,commentsCount,salesCount,costTime);
    }



    @RequestMapping("/async/goods/info")
    public String asyncGoodsInfo() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        System.out.println("异步查询商品信息的线程名称："+Thread.currentThread().getName());


        Future<Integer> collectsCountFuture = goodsService.getCollectsCountAsync();
        Future<Integer> commentsCountFuture = goodsService.getCommentsCountAsync();
        Future<Integer> salesCountFuture = goodsService.getSalesCountAsync();

        int collectsCount = collectsCountFuture.get();
        int commentsCount= commentsCountFuture.get();
        int salesCount= salesCountFuture.get();
        long costTime = System.currentTimeMillis()-startTime;
        return String.format("异步查询商品信息=收藏数%d==评论数%d==销量%d 执行完成====花费%d毫秒"
                ,collectsCount,commentsCount,salesCount,costTime);
    }

}
