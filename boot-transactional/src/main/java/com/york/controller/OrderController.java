package com.york.controller;

import com.york.common.ResponseJson;
import com.york.dao.entity.OrderItemEntity;
import com.york.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: York.Hwang
 * @Date: 2019/12/30 00:05
 */
@RestController
@RequestMapping("/")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/add/order")
    @ResponseBody
    public ResponseJson addOrder(long goodsId, int count){
        long userId = 100L;
        OrderItemEntity orderItemEntity = orderService.addOrder(goodsId, userId, count);
        return ResponseJson.success(orderItemEntity);
    }
}
