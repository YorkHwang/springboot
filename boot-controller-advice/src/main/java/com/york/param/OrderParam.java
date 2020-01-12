package com.york.param;

import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * @Description:创建订单参数
 * @Author: York.Hwang
 * @Date: 2020/1/11 23:35
 */
@Data
public class OrderParam {

    @NotNull
    private Long goodsId;

    @NotNull
    private Long userId;

    @NotNull
    private Integer amount;

}
