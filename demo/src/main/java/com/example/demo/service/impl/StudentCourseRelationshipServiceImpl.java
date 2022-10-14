package com.example.demo.service.impl;

import com.example.demo.mapper.StudentCourseRelationshipMapper;
import com.example.demo.pojo.StudentCourseRelationship;
import com.example.demo.service.StudentCourseRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCourseRelationshipServiceImpl implements StudentCourseRelationshipService {

    @Autowired
    private StudentCourseRelationshipMapper studentCourseRelationshipMapper;

    @Override
    public int save(StudentCourseRelationship ship) {
        return studentCourseRelationshipMapper.insertSelective(ship);
    }
}
