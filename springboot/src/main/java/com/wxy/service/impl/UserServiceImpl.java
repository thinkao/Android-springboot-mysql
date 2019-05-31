package com.wxy.service.impl;

import com.wxy.dao.UserDao;
import com.wxy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserDao {
    
    @Override
    public List<User> getUserAll() {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void deleteUser(String username) {

    }
}
