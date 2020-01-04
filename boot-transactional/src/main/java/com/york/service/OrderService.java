package com.york.service;

import com.york.common.BusinessException;
import com.york.dao.entity.OrderItemEntity;
import com.york.dao.mapper.GoodStockEntityMapper;
import com.york.dao.mapper.OrderItemEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @Description:
 * @Author: York.Hwang
 * @Date: 2019/12/30 00:07
 */
@Service
public class OrderService {

    @Autowired
    OrderItemEntityMapper orderItemEntityMapper;


    @Autowired
    GoodStockEntityMapper goodStockEntityMapper;



    @Transactional(noRollbackFor = RuntimeException.class)
    public OrderItemEntity addOrder(long goodsId, long userId, int count) throws Exception {
        //创建订单
        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setOrderNo(UUID.randomUUID().toString().replace("-",""));
        orderItemEntity.setPrice(getGoodsPrice(goodsId));
        orderItemEntity.setUserId(userId);
        orderItemEntity.setCount(count);
        orderItemEntity.setGoodsId(goodsId);
        orderItemEntityMapper.insertSelective(orderItemEntity);

        //扣减库存
        int updateRows = goodStockEntityMapper.reduceStock(goodsId, count);
        if(updateRows <= 0){
            throw new BusinessException("下单失败，库存不足！");
        }

        if(true) {
            throw new RuntimeException("手动抛出异常，但是不回滚");
        }




        return getOrder(orderItemEntity.getItemId());
    }



    private BigDecimal getGoodsPrice(long goodsId){
        return new BigDecimal(goodsId);
    }


    @Transactional(readOnly = true)
    public OrderItemEntity getOrder(Long itemId){
        return orderItemEntityMapper.selectByPrimaryKey(itemId);
    }
}
