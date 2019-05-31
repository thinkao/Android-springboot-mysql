package com.wxy.dao;

import com.wxy.pojo.List_list;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ListDao {

    List<List_list> getListAll();
}
