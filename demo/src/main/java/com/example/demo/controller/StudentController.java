package com.example.demo.controller;

import com.example.demo.commons.constants.Constants;
import com.example.demo.commons.pojo.ReturnMsgObj;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.StudentCourseRelationship;
import com.example.demo.service.StudentCourseRelationshipService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentCourseRelationshipService studentCourseRelationshipService;

    @RequestMapping("/student/queryByConditionForPage")
    @ResponseBody
    public Object queryByConditionForPage(Student student,Integer pageSize,Integer pageNo){

        if(pageSize==null || pageNo==null){
            return null;
        }

        //封装参数
        Map<String,Object> map = new HashMap<>();
        map.put("student",student);
        map.put("pageSize",pageSize);
        map.put("startNo",(pageNo-1)*pageSize);

        List<Student> studentList = studentService.queryByConditionForPage(map);
        int totalRows = studentService.queryCountByCondition(map);

        //创建返回的map
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("studentList",studentList);
        resultMap.put("totalRows",totalRows);


        return resultMap;
    }

    @RequestMapping("/student/removeById")
    @ResponseBody
    public Object removeById(Long id){

        //生成返回信息对象
        ReturnMsgObj msgObj = new ReturnMsgObj();

        try {
            int count = studentService.removeById(id);
            if(count>0){
                //删除成功
                msgObj.setCode(Constants.MSG_OBJ_CODE_SUCCESS);
            }else {
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

    @RequestMapping("/student/removeByIds")
    @ResponseBody
    public Object removeByIds(Long[] id){

        //生成返回信息对象
        ReturnMsgObj msgObj = new ReturnMsgObj();

        try {
            int count = studentService.removeByIds(id);
            if(count>0){
                //删除成功
                msgObj.setCode(Constants.MSG_OBJ_CODE_SUCCESS);
            }else {
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

    @RequestMapping("/student/modify")
    @ResponseBody
    public Object modify(Student student){

        //生成返回信息对象
        ReturnMsgObj msgObj = new ReturnMsgObj();

        try {
            int count = studentService.modify(student);
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

    @RequestMapping("/student/save")
    @ResponseBody
    public Object save(Student student){

        //生成返回信息对象
        ReturnMsgObj msgObj = new ReturnMsgObj();

        try {
            int count = studentService.save(student);
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

    @RequestMapping("/student/saveByList")
    @ResponseBody
    public Object saveByList(List<Student> list){

        //生成返回信息对象
        ReturnMsgObj msgObj = new ReturnMsgObj();

        try {
            int count = studentService.saveByList(list);
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

    /**
     * 学生和课程的关联保存
     */
    @RequestMapping("/student/saveStudentCourseRelationship")
    @ResponseBody
    public Object saveStudentCourseRelationship(StudentCourseRelationship ship){

        //创建返回信息对象
        ReturnMsgObj msgObj = new ReturnMsgObj();

        //保存关联关系
        try {
            int count = studentCourseRelationshipService.save(ship);
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

    /**
     * 查询某个学生的信息以及所关联的课程信息
     */
    @RequestMapping("/student/queryStudentAndCourses")
    @ResponseBody
    public Object queryStudentAndCourses(Long id){
        return studentService.queryStudentAndCourses(id);
    }
}
