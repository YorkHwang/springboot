package com.york.dao.base;

import org.apache.ibatis.annotations.InsertProvider;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

public interface  BaseMapper<T> extends tk.mybatis.mapper.common.BaseMapper<T>, ExampleMapper<T>, MySqlMapper<T> {

    @InsertProvider(type = BatchProvider.class, method = "dynamicSQL")
    int batchInsert(List<T> recordList);

}
