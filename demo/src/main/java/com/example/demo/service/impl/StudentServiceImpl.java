package com.example.demo.service.impl;

import com.example.demo.mapper.CourseMapper;
import com.example.demo.mapper.StudentCourseRelationshipMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.pojo.Course;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.StudentCourseRelationship;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentCourseRelationshipMapper studentCourseRelationshipMapper;
    @Autowired
    private CourseMapper courseMapper;


    @Override
    public List<Student> queryByConditionForPage(Map map) {
        return studentMapper.selectByConditionForPage(map);
    }

    @Override
    public int removeById(Long id) {

        //根据学生id查询对应的关联关系
        List<StudentCourseRelationship> list = studentCourseRelationshipMapper.selectByStudentId(id);

        //删除与课程的关联信息
        for(StudentCourseRelationship ship:list){
            studentCourseRelationshipMapper.deleteByPrimaryKey(ship.getId());
        }

        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int removeByIds(Long[] ids) {

        for(Long id:ids){

            //根据学生id查询对应的关联关系
            List<StudentCourseRelationship> list = studentCourseRelationshipMapper.selectByStudentId(id);

            //删除与课程的关联信息
            for(StudentCourseRelationship ship:list){
                studentCourseRelationshipMapper.deleteByPrimaryKey(ship.getId());
            }
        }

        return studentMapper.deleteByIds(ids);
    }

    @Override
    public int modify(Student student) {
        return studentMapper.updateByPrimaryKey(student);
    }

    @Override
    public int save(Student student) {
        return studentMapper.insertSelective(student);
    }

    @Override
    public int saveByList(List<Student> list) {
        return studentMapper.insertByList(list);
    }

    @Override
    public int queryCountByCondition(Map map) {
        return studentMapper.selectCountByCondition(map);
    }

    @Override
    public Map<String, Object> queryStudentAndCourses(Long id) {

        Map<String,Object> map = new HashMap<>();

        //查询学生信息
        Student student = studentMapper.selectByPrimaryKey(id);
        //根据学生id查询所有关联关系
        List<StudentCourseRelationship> ships = studentCourseRelationshipMapper.selectByStudentId(id);

        List<Course> courseList = new ArrayList<>();

        //根据关联关系查询所有课程信息，并加到集合中
        for(StudentCourseRelationship ship:ships){
            courseList.add(courseMapper.selectByPrimaryKey(ship.getCourseId()));
        }

        //封装参数
        map.put("student",student);
        map.put("courseList",courseList);

        return map;
    }


}
