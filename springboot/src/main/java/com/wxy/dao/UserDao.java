package com.wxy.dao;

import com.wxy.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    List<User> getUserAll();

    void addUser(User user);

    void deleteUser(String username);
}
