package com.wxy.dao;

import com.wxy.pojo.Grade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GradeDao {

    List<Grade> getGradeAll();
}
