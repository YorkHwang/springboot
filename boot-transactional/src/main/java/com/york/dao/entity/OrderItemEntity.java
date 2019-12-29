package com.york.dao.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.*;

@ApiModel("订单项表")
@Table(name = "order_item")
public class OrderItemEntity {
    /**
     * 订单ID
     */
    @Id
    @Column(name = "item_id")
    @ApiModelProperty("订单ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "JDBC")
    private Long itemId;

    /**
     * 订单号
     */
    @Column(name = "order_no")
    @ApiModelProperty("订单号")
    private String orderNo;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    @ApiModelProperty("用户ID")
    private Long userId;

    /**
     * 商品ID
     */
    @Column(name = "goods_id")
    @ApiModelProperty("商品ID")
    private Long goodsId;

    /**
     * 单价
     */
    @ApiModelProperty("单价")
    private BigDecimal price;

    /**
     * 数量
     */
    @ApiModelProperty("数量")
    private Integer count;

    /**
     * 获取订单ID
     *
     * @return item_id - 订单ID
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * 设置订单ID
     *
     * @param itemId 订单ID
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * 获取订单号
     *
     * @return order_no - 订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置订单号
     *
     * @param orderNo 订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取商品ID
     *
     * @return goods_id - 商品ID
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * 设置商品ID
     *
     * @param goodsId 商品ID
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取单价
     *
     * @return price - 单价
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置单价
     *
     * @param price 单价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取数量
     *
     * @return count - 数量
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置数量
     *
     * @param count 数量
     */
    public void setCount(Integer count) {
        this.count = count;
    }
}