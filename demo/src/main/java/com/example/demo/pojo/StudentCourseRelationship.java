package com.example.demo.pojo;

import lombok.ToString;

@ToString
public class StudentCourseRelationship {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_course_relationship.id
     *
     * @mbggenerated Fri Oct 14 01:21:17 CST 2022
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_course_relationship.student_id
     *
     * @mbggenerated Fri Oct 14 01:21:17 CST 2022
     */
    private Long studentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_course_relationship.course_id
     *
     * @mbggenerated Fri Oct 14 01:21:17 CST 2022
     */
    private Long courseId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_course_relationship.id
     *
     * @return the value of student_course_relationship.id
     *
     * @mbggenerated Fri Oct 14 01:21:17 CST 2022
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_course_relationship.id
     *
     * @param id the value for student_course_relationship.id
     *
     * @mbggenerated Fri Oct 14 01:21:17 CST 2022
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_course_relationship.student_id
     *
     * @return the value of student_course_relationship.student_id
     *
     * @mbggenerated Fri Oct 14 01:21:17 CST 2022
     */
    public Long getStudentId() {
        return studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_course_relationship.student_id
     *
     * @param studentId the value for student_course_relationship.student_id
     *
     * @mbggenerated Fri Oct 14 01:21:17 CST 2022
     */
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_course_relationship.course_id
     *
     * @return the value of student_course_relationship.course_id
     *
     * @mbggenerated Fri Oct 14 01:21:17 CST 2022
     */
    public Long getCourseId() {
        return courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_course_relationship.course_id
     *
     * @param courseId the value for student_course_relationship.course_id
     *
     * @mbggenerated Fri Oct 14 01:21:17 CST 2022
     */
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
