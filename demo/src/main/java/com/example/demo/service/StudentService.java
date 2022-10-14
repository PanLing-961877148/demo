package com.example.demo.service;

import com.example.demo.pojo.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    List<Student> queryByConditionForPage(Map map);

    int removeById(Long id);

    int removeByIds(Long[] ids);

    int modify(Student student);

    int save(Student student);

    int saveByList(List<Student> list);

    int queryCountByCondition(Map map);

    Map<String,Object> queryStudentAndCourses(Long id);
}
