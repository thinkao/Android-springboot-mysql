package com.wxy.controller;

import com.wxy.dao.UserDao;
import com.wxy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @ResponseBody
    public List<User> user(){
        List<User> userList = userDao.getUserAll();
        return userList;
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(@RequestParam("uname")String uname,@RequestParam("username")String username,
                          @RequestParam("upassword")String upassword, User user){
        userDao.addUser(user);
        System.out.println("可以正常执行");
        return "redirect:/user/getAll";
    }
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(){
        return "register";
    }
    @RequestMapping(value = "/delete/{username}",method = RequestMethod.POST)
    public String delete(@PathVariable("username") String username){
        System.out.println("可以删除");
        userDao.deleteUser(username);
        return "redirect:/user/getAll";
    }
}
