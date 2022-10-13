package com.example.demo.service.impl;

import com.example.demo.mapper.CourseMapper;
import com.example.demo.mapper.StudentCourseRelationshipMapper;
import com.example.demo.pojo.Course;
import com.example.demo.pojo.StudentCourseRelationship;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private StudentCourseRelationshipMapper studentCourseRelationshipMapper;

    @Override
    public List<Course> queryByConditionForPage(Map map) {
        return courseMapper.selectByConditionForPage(map);
    }

    @Override
    public int removeById(Long id) {

        //根据课程id查询对应的关联关系
        List<StudentCourseRelationship> list = studentCourseRelationshipMapper.selectByCourseId(id);

        if(list!=null && list.size()>0){
            //有关联关系，无法删除
            return 0;
        }else {
            //没关联关系，进行删除
            return courseMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public int removeByIds(Long[] ids) {

        for(Long id:ids){
            //根据课程id查询对应的关联关系
            List<StudentCourseRelationship> list = studentCourseRelationshipMapper.selectByCourseId(id);

            if(list!=null && list.size()>0){
                //有关联关系，无法删除
                return 0;
            }else {
                //没关联关系，进行删除
                return courseMapper.deleteByPrimaryKey(id);
            }
        }

        return 0;
    }

    @Override
    public int modify(Course course) {
        return courseMapper.updateByPrimaryKey(course);
    }

    @Override
    public int save(Course course) {
        return courseMapper.insert(course);
    }

    @Override
    public int saveByList(List<Course> list) {
        return courseMapper.insertByList(list);
    }
}
