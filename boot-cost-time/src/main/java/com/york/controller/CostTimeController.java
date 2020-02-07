package com.york.controller;

import com.york.service.CostTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: York.Hwang
 * @Date: 2020/2/7 12:23
 */
@RequestMapping("/")
@RestController
public class CostTimeController {

    @Autowired
    CostTimeService costTimeService;

    @RequestMapping("/index")
    public String index() throws InterruptedException {
        return costTimeService.costTime();
    }
}
