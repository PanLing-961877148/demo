package com.example.demo.controller;

import com.example.demo.commons.constants.Constants;
import com.example.demo.commons.pojo.ReturnMsgObj;
import com.example.demo.pojo.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/course/queryByConditionForPage")
    @ResponseBody
    public Object queryByConditionForPage(String courseName, Integer pageSize, Integer pageNo){

        if(pageSize==null || pageNo==null){
            return null;
        }

        //封装参数
        Map<String,Object> map = new HashMap<>();
        map.put("courseName",courseName);
        map.put("pageSize",pageSize);
        map.put("startNo",(pageNo-1)*pageSize);

        List<Course> courseList = courseService.queryByConditionForPage(map);
        int totalRows = courseService.queryCountByCondition(map);

        //创建返回的map
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("courseList",courseList);
        resultMap.put("totalRows",totalRows);


        return resultMap;
    }

    @RequestMapping("/course/removeById")
    @ResponseBody
    public Object removeById(Long id){

        //生成返回信息对象
        ReturnMsgObj msgObj = new ReturnMsgObj();

        try {
            int count = courseService.removeById(id);
            if(count>0){
                //删除成功
                msgObj.setCode(Constants.MSG_OBJ_CODE_SUCCESS);
            }else if(count == -1){
                //删除失败
                msgObj.setCode(Constants.MSG_OBJ_CODE_FAILURE);
                msgObj.setMessage("有学生选的课程不能被删除！");
            } else {
                //删除失败
                msgObj.setCode(Constants.MSG_OBJ_CODE_FAILURE);
                msgObj.setMessage("系统繁忙，请稍后重试！");
            }

        } catch (Exception e) {
            //删除失败
            msgObj.setCode(Constants.MSG_OBJ_CODE_FAILURE);
            msgObj.setMessage("系统繁忙，请稍后重试！");
            e.printStackTrace();
        }

        return msgObj;
    }

    @RequestMapping("/course/removeByIds")
    @ResponseBody
    public Object removeByIds(Long[] id){

        //生成返回信息对象
        ReturnMsgObj msgObj = new ReturnMsgObj();

        try {
            int count = courseService.removeByIds(id);
            if(count>0){
                //删除成功
                msgObj.setCode(Constants.MSG_OBJ_CODE_SUCCESS);
            }else if (count==-1){
                //删除失败
                msgObj.setCode(Constants.MSG_OBJ_CODE_FAILURE);
                msgObj.setMessage("有学生选的课程不能被删除！");
            } else {
                //删除失败
                msgObj.setCode(Constants.MSG_OBJ_CODE_FAILURE);
                msgObj.setMessage("系统繁忙，请稍后重试！");
            }

        } catch (Exception e) {
            //删除失败
            msgObj.setCode(Constants.MSG_OBJ_CODE_FAILURE);
            msgObj.setMessage("系统繁忙，请稍后重试！");
            e.printStackTrace();
        }

        return msgObj;
    }

    @RequestMapping("/course/modify")
    @ResponseBody
    public Object modify(Course course){

        //生成返回信息对象
        ReturnMsgObj msgObj = new ReturnMsgObj();

        try {
            int count = courseService.modify(course);
            if(count>0){
                //修改成功
                msgObj.setCode(Constants.MSG_OBJ_CODE_SUCCESS);
            }else {
                //修改失败
                msgObj.setCode(Constants.MSG_OBJ_CODE_FAILURE);
                msgObj.setMessage("系统繁忙，请稍后重试！");
            }

        } catch (Exception e) {
            //修改失败
            msgObj.setCode(Constants.MSG_OBJ_CODE_FAILURE);
            msgObj.setMessage("系统繁忙，请稍后重试！");
            e.printStackTrace();
        }

        return msgObj;
    }

    @RequestMapping("/course/save")
    @ResponseBody
    public Object save(Course course){

        //生成返回信息对象
        ReturnMsgObj msgObj = new ReturnMsgObj();

        try {
            int count = courseService.save(course);
            if(count>0){
                //保存成功
                msgObj.setCode(Constants.MSG_OBJ_CODE_SUCCESS);
            }else {
                //保存失败
                msgObj.setCode(Constants.MSG_OBJ_CODE_FAILURE);
                msgObj.setMessage("系统繁忙，请稍后重试！");
            }

        } catch (Exception e) {
            //保存失败
            msgObj.setCode(Constants.MSG_OBJ_CODE_FAILURE);
            msgObj.setMessage("系统繁忙，请稍后重试！");
            e.printStackTrace();
        }

        return msgObj;
    }

    @RequestMapping("/course/saveByList")
    @ResponseBody
    public Object saveByList(List<Course> list){

        //生成返回信息对象
        ReturnMsgObj msgObj = new ReturnMsgObj();

        try {
            int count = courseService.saveByList(list);
            if(count>0){
                //保存成功
                msgObj.setCode(Constants.MSG_OBJ_CODE_SUCCESS);
            }else {
                //保存失败
                msgObj.setCode(Constants.MSG_OBJ_CODE_FAILURE);
                msgObj.setMessage("系统繁忙，请稍后重试！");
            }

        } catch (Exception e) {
            //保存失败
            msgObj.setCode(Constants.MSG_OBJ_CODE_FAILURE);
            msgObj.setMessage("系统繁忙，请稍后重试！");
            e.printStackTrace();
        }

        return msgObj;
    }
}
