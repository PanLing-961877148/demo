package com.example.demo.service.impl;

import com.example.demo.mapper.CourseMapper;
import com.example.demo.mapper.StudentCourseRelationshipMapper;
import com.example.demo.pojo.Course;
import com.example.demo.pojo.StudentCourseRelationship;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
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
            return -1;
        }else {
            //没关联关系，进行删除
            return courseMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public int removeByIds(Long[] ids) {

        int count = 0;

        for(Long id:ids){
            //根据课程id查询对应的关联关系
            List<StudentCourseRelationship> list = studentCourseRelationshipMapper.selectByCourseId(id);

            if(list!=null && list.size()>0){
                //有关联关系，无法删除
                return -1;
            }else {
                //没关联关系，进行删除
                courseMapper.deleteByPrimaryKey(id);
                count++;
            }
        }

        return count;
    }

    @Override
    public int modify(Course course) {
        return courseMapper.updateByPrimaryKey(course);
    }

    @Override
    public int save(Course course) {
        return courseMapper.insertSelective(course);
    }

    @Override
    public int saveByList(List<Course> list) {
        return courseMapper.insertByList(list);
    }

    @Override
    public int queryCountByCondition(Map map) {
        return courseMapper.selectCountByCondition(map);
    }
}
