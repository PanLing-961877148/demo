package com.example.demo.service;

import com.example.demo.pojo.Course;

import java.util.List;
import java.util.Map;

public interface CourseService {

    List<Course> queryByConditionForPage(Map map);

    int removeById(Long id);

    int removeByIds(Long[] ids);

    int modify(Course course);

    int save(Course course);

    int saveByList(List<Course> list);

    int queryCountByCondition(Map map);
}
