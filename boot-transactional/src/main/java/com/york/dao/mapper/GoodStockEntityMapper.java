package com.york.dao.mapper;

import com.york.dao.base.BaseMapper;
import com.york.dao.entity.GoodStockEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodStockEntityMapper extends BaseMapper<GoodStockEntity> {

    @Update("update good_stock set sold=sold+#{reduceCount} where goods_id =#{goodsId} and total>=sold+#{reduceCount};")
    int reduceStock(@Param("goodsId") long goodsId, @Param("reduceCount") int reduceCount);
}