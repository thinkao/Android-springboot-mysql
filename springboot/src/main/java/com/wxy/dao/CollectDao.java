package com.wxy.dao;

import com.wxy.pojo.Collect;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CollectDao {
    List<Collect> getCollectAll();
}
