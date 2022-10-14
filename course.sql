/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2022-10-14 16:18:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(128) DEFAULT NULL,
  `credit` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '语文', '3');
INSERT INTO `course` VALUES ('2', '数学', '5');
INSERT INTO `course` VALUES ('3', '英语', '4');
INSERT INTO `course` VALUES ('4', 'c语言', '4');
INSERT INTO `course` VALUES ('6', 'java', '5');
INSERT INTO `course` VALUES ('7', '高数', '5');
INSERT INTO `course` VALUES ('8', null, null);
INSERT INTO `course` VALUES ('92', '高山', null);
