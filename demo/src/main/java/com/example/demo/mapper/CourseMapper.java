package com.example.demo.mapper;

import com.example.demo.pojo.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CourseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Fri Oct 14 00:06:58 CST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Fri Oct 14 00:06:58 CST 2022
     */
    int insert(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Fri Oct 14 00:06:58 CST 2022
     */
    int insertSelective(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Fri Oct 14 00:06:58 CST 2022
     */
    Course selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Fri Oct 14 00:06:58 CST 2022
     */
    int updateByPrimaryKeySelective(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Fri Oct 14 00:06:58 CST 2022
     */
    int updateByPrimaryKey(Course record);

    /**
     * 根据条件进行分页查询
     */
    List<Course> selectByConditionForPage(Map map);

    /**
     * 批量保存
     */
    int insertByList(List<Course> list);

    /**
     * 按条件查询总条数
     */
    int selectCountByCondition(Map map);
}