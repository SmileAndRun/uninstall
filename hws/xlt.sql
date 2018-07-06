/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : xlt

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-07-06 15:00:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `barrage`
-- ----------------------------
DROP TABLE IF EXISTS `barrage`;
CREATE TABLE `barrage` (
  `contentId` varchar(50) NOT NULL COMMENT '唯一标识',
  `content` varchar(255) NOT NULL COMMENT '内容',
  `time` datetime NOT NULL COMMENT '时间',
  PRIMARY KEY (`contentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of barrage
-- ----------------------------
INSERT INTO `barrage` VALUES ('1', '啦啦啦啦啦啦啦啦啦啦啦啦', '2018-06-28 20:02:00');
INSERT INTO `barrage` VALUES ('2', '628', '2018-07-05 14:23:34');
INSERT INTO `barrage` VALUES ('3', '我想你', '2018-07-03 14:24:16');
INSERT INTO `barrage` VALUES ('4', '今天下雨', '2018-07-03 14:24:34');
INSERT INTO `barrage` VALUES ('5', '趁加班来看看6000寸的大屏', '2018-07-01 14:25:00');
INSERT INTO `barrage` VALUES ('6', '今天下雨，被淋成了落汤鸡', '2018-07-04 20:21:42');
INSERT INTO `barrage` VALUES ('7', '今天心情超级好', '2018-07-05 14:26:24');
