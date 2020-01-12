package com.york.controller;

import com.alibaba.fastjson.JSON;
import com.york.common.BusinessException;
import com.york.common.JsonResponse;
import com.york.param.OrderParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Description: 订单控制类
 * @Author: York.Hwang
 * @Date: 2020/1/12 21:18
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private static Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @RequestMapping("create")
    @ResponseBody
    public JsonResponse createOrder(@Valid OrderParam orderParam){
        LOG.info("order creating , param={}", JSON.toJSON(orderParam));
        if (true) {
            throw new BusinessException("扣减库存异常");
        }
        return JsonResponse.success(1000L).setMsg("订单创建成功！");
    }




}
