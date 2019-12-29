package com.york.dao.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;

@ApiModel("商品库存表")
@Table(name = "good_stock")
public class GoodStockEntity {
    /**
     * 库存ID
     */
    @Id
    @Column(name = "stock_id")
    @ApiModelProperty("库存ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "JDBC")
    private Long stockId;

    /**
     * 商品ID
     */
    @Column(name = "goods_id")
    @ApiModelProperty("商品ID")
    private Long goodsId;

    /**
     * 总数量
     */
    @ApiModelProperty("总数量")
    private Integer total;

    /**
     * 已售出
     */
    @ApiModelProperty("已售出")
    private Integer sold;

    /**
     * 获取库存ID
     *
     * @return stock_id - 库存ID
     */
    public Long getStockId() {
        return stockId;
    }

    /**
     * 设置库存ID
     *
     * @param stockId 库存ID
     */
    public void setStockId(Long stockId) {
        this.stockId = stockId;
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
     * 获取总数量
     *
     * @return total - 总数量
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * 设置总数量
     *
     * @param total 总数量
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * 获取已售出
     *
     * @return sold - 已售出
     */
    public Integer getSold() {
        return sold;
    }

    /**
     * 设置已售出
     *
     * @param sold 已售出
     */
    public void setSold(Integer sold) {
        this.sold = sold;
    }
}