/*
Navicat MySQL Data Transfer

Source Server         : mysql57
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : kzfire

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2019-04-15 17:46:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL,
  `login_time` date DEFAULT NULL,
  `login_ip` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login_log
-- ----------------------------
INSERT INTO `login_log` VALUES ('3', '1', '2019-04-15', '127.0.0.1');
INSERT INTO `login_log` VALUES ('4', '1', '2019-04-15', '127.0.0.1');
INSERT INTO `login_log` VALUES ('5', '1', '2019-04-15', '127.0.0.1');
INSERT INTO `login_log` VALUES ('6', '1', '2019-04-15', '127.0.0.1');
INSERT INTO `login_log` VALUES ('7', '1', '2019-04-15', '127.0.0.1');
INSERT INTO `login_log` VALUES ('8', '1', '2019-04-15', '127.0.0.1');
INSERT INTO `login_log` VALUES ('9', '1', '2019-04-15', '127.0.0.1');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(50) DEFAULT NULL,
  `pid` int(10) DEFAULT NULL,
  `is_end` int(10) DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', '天津供电', '1', '0');
INSERT INTO `sys_dept` VALUES ('2', '供电技术科', '1', null);
INSERT INTO `sys_dept` VALUES ('3', '物资科', '1', null);
INSERT INTO `sys_dept` VALUES ('4', '机电库', '3', null);
INSERT INTO `sys_dept` VALUES ('5', '劳保库', '3', null);
INSERT INTO `sys_dept` VALUES ('6', '工具库', '3', null);
INSERT INTO `sys_dept` VALUES ('7', '水电技术科', '1', null);

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `permission_code` varchar(50) DEFAULT NULL,
  `permission_desc` varchar(50) DEFAULT NULL,
  `path` varchar(250) DEFAULT NULL,
  `pid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '1001', '员工查看', '/user/user/list.do', '员工管理');
INSERT INTO `sys_permission` VALUES ('2', '1002', '员工删除', '/user/user/list.do', '员工管理');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(50) DEFAULT NULL,
  `role_desc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '1', '管理员');
INSERT INTO `sys_role` VALUES ('2', '2', '总监');
INSERT INTO `sys_role` VALUES ('3', '3', '经理');
INSERT INTO `sys_role` VALUES ('4', '4', '开发人员');
INSERT INTO `sys_role` VALUES ('5', '5', '业务指导');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(10) DEFAULT NULL,
  `permission_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '1', '2');
INSERT INTO `sys_role_permission` VALUES ('3', '2', '1');
INSERT INTO `sys_role_permission` VALUES ('4', '2', '2');
INSERT INTO `sys_role_permission` VALUES ('5', '3', '1');
INSERT INTO `sys_role_permission` VALUES ('6', '3', '2');
INSERT INTO `sys_role_permission` VALUES ('7', '4', '1');
INSERT INTO `sys_role_permission` VALUES ('8', '4', '2');
INSERT INTO `sys_role_permission` VALUES ('9', '5', '1');
INSERT INTO `sys_role_permission` VALUES ('10', '5', '2');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `real_name` varchar(50) DEFAULT NULL,
  `id_card` varchar(50) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `is_use` int(11) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `join_time` date DEFAULT NULL,
  `left_time` date DEFAULT NULL,
  `job_lvl` int(11) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `addr` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '123456', 'wei', '41', '1', '15', '1', '2017-05-23', '2017-05-23', null, '3', '137608', '');
INSERT INTO `sys_user` VALUES ('2', 'tjgddwzk', '123456', '甘先生', '12010519660601213X', '1', '53', '1', '1966-06-01', '1987-08-07', null, '3', '13822233456', '天津北城');
INSERT INTO `sys_user` VALUES ('3', 'tjgddwzk2', '123456', '甘先生2', '12010519660601213X', '1', '53', '1', '1966-06-01', '1987-08-07', null, '3', '13822233456', '天津滨海');

-- ----------------------------
-- Table structure for sys_user_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_dept`;
CREATE TABLE `sys_user_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL,
  `dept_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_dept
-- ----------------------------
INSERT INTO `sys_user_dept` VALUES ('1', '1', '1');
INSERT INTO `sys_user_dept` VALUES ('2', '2', '2');
INSERT INTO `sys_user_dept` VALUES ('5', '3', '3');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL,
  `role_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=141 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('127', '1', '1');
INSERT INTO `sys_user_role` VALUES ('128', '1', '2');
INSERT INTO `sys_user_role` VALUES ('129', '1', '3');
INSERT INTO `sys_user_role` VALUES ('130', '1', '4');
INSERT INTO `sys_user_role` VALUES ('131', '1', '5');
INSERT INTO `sys_user_role` VALUES ('132', '3', '1');
INSERT INTO `sys_user_role` VALUES ('133', '3', '2');
INSERT INTO `sys_user_role` VALUES ('134', '3', '3');
INSERT INTO `sys_user_role` VALUES ('135', '3', '4');
INSERT INTO `sys_user_role` VALUES ('136', '2', '1');
INSERT INTO `sys_user_role` VALUES ('137', '2', '2');
INSERT INTO `sys_user_role` VALUES ('138', '2', '3');
INSERT INTO `sys_user_role` VALUES ('139', '2', '4');
INSERT INTO `sys_user_role` VALUES ('140', '2', '5');
