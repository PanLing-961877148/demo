package com.example.demo.service.impl;

import com.example.demo.mapper.StudentCourseRelationshipMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.StudentCourseRelationship;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentCourseRelationshipMapper studentCourseRelationshipMapper;


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
        return studentMapper.updateByPrimaryKey(student);
    }

    @Override
    public int saveByList(List<Student> list) {
        return studentMapper.insertByList(list);
    }


}
