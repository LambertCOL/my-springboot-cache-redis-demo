/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : springbootdata

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2020-04-20 10:25:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `content` longtext COMMENT '评论内容',
  `author` varchar(200) DEFAULT NULL COMMENT '评论者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '作者你能不能快点', '卢姥爷');
INSERT INTO `comment` VALUES ('2', '给作者倒一杯卡布奇诺', '法外狂徒张三');
INSERT INTO `comment` VALUES ('3', '我当场把电脑屏幕吃掉', '李思思');
INSERT INTO `comment` VALUES ('4', '当年陈刀仔年能用20块赢到3700万', '卢本伟');
INSERT INTO `comment` VALUES ('5', '得得得得得得得得得得得得', '卢本伟');
