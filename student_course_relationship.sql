/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2022-10-14 16:19:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student_course_relationship
-- ----------------------------
DROP TABLE IF EXISTS `student_course_relationship`;
CREATE TABLE `student_course_relationship` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_id` bigint(20) DEFAULT NULL,
  `course_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_course_relationship
-- ----------------------------
INSERT INTO `student_course_relationship` VALUES ('1', '1', '7');
INSERT INTO `student_course_relationship` VALUES ('2', '2', '7');
INSERT INTO `student_course_relationship` VALUES ('3', '1', '2');
INSERT INTO `student_course_relationship` VALUES ('4', '1', '3');
INSERT INTO `student_course_relationship` VALUES ('5', '4', '1');
INSERT INTO `student_course_relationship` VALUES ('6', '4', '2');
