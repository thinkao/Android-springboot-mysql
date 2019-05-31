package com.wxy.controller;

import com.wxy.dao.ListDao;
import com.wxy.pojo.List_list;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/list")
public class ListController {

    @Autowired
    private ListDao listDao;

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @ResponseBody
    public List<List_list> list(){
        List<List_list> list_listList = listDao.getListAll();
        return list_listList;
    }
}
