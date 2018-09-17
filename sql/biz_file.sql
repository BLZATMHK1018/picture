/*
Navicat MySQL Data Transfer

Source Server         : local_zf
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : technology

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-09-17 17:00:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for biz_file
-- ----------------------------
DROP TABLE IF EXISTS `biz_file`;
CREATE TABLE `biz_file` (
  `ID_AUTO` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `URL` varchar(255) NOT NULL COMMENT '地址',
  `NAME` varchar(80) DEFAULT NULL COMMENT 'NAME',
  `ID` varchar(10) DEFAULT NULL COMMENT 'webuploader的文件id',
  `SIZE` varchar(40) DEFAULT NULL COMMENT 'webuploader的文件大小',
  `TYPE` varchar(20) DEFAULT NULL COMMENT '图片类型',
  `CREATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_AUTO`)
) ENGINE=InnoDB AUTO_INCREMENT=697 DEFAULT CHARSET=utf8;
