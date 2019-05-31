package com.wxy.controller;

import com.wxy.dao.CollectDao;
import com.wxy.pojo.Collect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    private CollectDao collectDao;

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @ResponseBody
    public List<Collect> collect(){
        List<Collect> collectList = collectDao.getCollectAll();
        return collectList;
    }
}
