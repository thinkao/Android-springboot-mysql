package com.wxy.controller;

import com.wxy.dao.GradeDao;
import com.wxy.pojo.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/grade")
public class GradeController {

    @Autowired
    private GradeDao gradeDao;


    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @ResponseBody
    public List<Grade> getAll(){
        List<Grade> gradeList = gradeDao.getGradeAll();
        System.out.println(gradeList);
        return gradeList;
    }
}
