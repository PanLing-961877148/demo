package com.example.demo.controller;

import com.example.demo.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    @RequestMapping("/student/query")
    @ResponseBody
    public Object queryByConditionForPage(Student student,String pageSize,String pageNo){


        return null;
    }
}
