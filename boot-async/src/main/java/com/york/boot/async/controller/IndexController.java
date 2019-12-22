package com.york.boot.async.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: York.Hwang
 * @Date: 2019/12/22 00:50
 */
@RequestMapping("/")
@RestController
public class IndexController {

    @ResponseBody
    @RequestMapping("/index")
    public String index(){
        return "hello world";
    }
}
