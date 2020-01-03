/*
Navicat MySQL Data Transfer

Source Server         : 101.132.185.105
Source Server Version : 50645
Source Host           : 101.132.185.105:3306
Source Database       : imageplatform

Target Server Type    : MYSQL
Target Server Version : 50645
File Encoding         : 65001

Date: 2020-01-03 15:52:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for album
-- ----------------------------
DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `album_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of album
-- ----------------------------

-- ----------------------------
-- Table structure for blacklist
-- ----------------------------
DROP TABLE IF EXISTS `blacklist`;
CREATE TABLE `blacklist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blacked_id` int(11) DEFAULT NULL,
  `blacker_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkayvqt4ywhr7w12awu20ae88w` (`blacked_id`),
  KEY `FKlx418pe4elxc3y1xevis77jjs` (`blacker_id`),
  CONSTRAINT `FKkayvqt4ywhr7w12awu20ae88w` FOREIGN KEY (`blacked_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKlx418pe4elxc3y1xevis77jjs` FOREIGN KEY (`blacker_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blacklist
-- ----------------------------
INSERT INTO `blacklist` VALUES ('1', '2', '1');
INSERT INTO `blacklist` VALUES ('2', '2', '3');
INSERT INTO `blacklist` VALUES ('3', '2', '6');
INSERT INTO `blacklist` VALUES ('4', '3', '2');
INSERT INTO `blacklist` VALUES ('5', '3', '5');
INSERT INTO `blacklist` VALUES ('7', '1', '2');

-- ----------------------------
-- Table structure for complaint
-- ----------------------------
DROP TABLE IF EXISTS `complaint`;
CREATE TABLE `complaint` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh8dg5n7ibjyack6pn6e71djj6` (`user_id`),
  CONSTRAINT `FKh8dg5n7ibjyack6pn6e71djj6` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of complaint
-- ----------------------------
INSERT INTO `complaint` VALUES ('1', '前不久，苹果公司高级副总裁 Eddy Cue 还在宣称 Apple Music 试用期用户超 1100 万，最近就有一份来自 MusicWatch 的调查报告，让人大跌眼镜。', '2019-12-26 17:31:16', '半数用户弃用 Apple Music？苹果发话了', '2');
INSERT INTO `complaint` VALUES ('2', 'dwa', '2019-12-26 17:32:19', '凡心所向，素履所往，生如逆旅，一苇以航', '2');
INSERT INTO `complaint` VALUES ('8', '新版的 Apple TV 之前一直有传闻将在 WWDC 上亮相，可是事与愿违。下一代 iPhone 即将于下月与大家见面，新版 Apple TV 将同新 iPhone 一起亮相的传言又是四起。而且现在的传言中还加入了新料。\n\n据 9to5Mac 的消息，Apple TV 不仅要在九月亮相，其诸多细节也一并被曝出。', '2019-12-27 08:37:04', '关于新 Apple TV，这里有几点你应该知道的', '3');
INSERT INTO `complaint` VALUES ('10', 'cs', '2020-01-02 18:59:25', '凡心所向，素履所往，生如逆旅，一苇以航', '2');

-- ----------------------------
-- Table structure for concern
-- ----------------------------
DROP TABLE IF EXISTS `concern`;
CREATE TABLE `concern` (
  `id` int(11) NOT NULL,
  `concern_time` datetime DEFAULT NULL,
  `concerner_id` int(11) NOT NULL AUTO_INCREMENT,
  `concerned_id` int(11) NOT NULL,
  PRIMARY KEY (`concerner_id`,`concerned_id`,`id`),
  UNIQUE KEY `UK_25nwvj1cruoe1r1fvmpda3m5b` (`id`),
  KEY `FKdjksxxhtek9bosyqrikuij50j` (`concerned_id`),
  CONSTRAINT `FKdjksxxhtek9bosyqrikuij50j` FOREIGN KEY (`concerned_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKjrm5un4an606qcy4anwr5n8lk` FOREIGN KEY (`concerner_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of concern
-- ----------------------------
INSERT INTO `concern` VALUES ('5', '2019-12-18 13:32:43', '1', '2');
INSERT INTO `concern` VALUES ('1', '2019-12-27 13:29:19', '2', '2');
INSERT INTO `concern` VALUES ('3', '2019-12-18 13:04:41', '2', '3');
INSERT INTO `concern` VALUES ('12', '2020-01-03 10:48:14', '2', '5');
INSERT INTO `concern` VALUES ('7', '2019-12-31 17:28:40', '4', '2');
INSERT INTO `concern` VALUES ('8', '2019-12-31 17:29:32', '4', '3');
INSERT INTO `concern` VALUES ('11', '2020-01-03 08:50:50', '4', '5');

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `click_num` int(11) DEFAULT NULL,
  `fname` varchar(255) DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  `upload_time` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfa3htlps9ddix2jx1spmpedko` (`user_id`),
  CONSTRAINT `FKfa3htlps9ddix2jx1spmpedko` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of picture
-- ----------------------------
INSERT INTO `picture` VALUES ('3', ',FlSbiCdwvIlVWMo96919deLOWuk8', null, 'admin', 'qqq', '2019-12-18 13:08:26', '1');
INSERT INTO `picture` VALUES ('4', ',FjoKbhs5_Wz1_I0GELC3OLdLStXz', null, 'e21', 'aaa', '2019-12-18 13:08:50', '1');
INSERT INTO `picture` VALUES ('5', ',Fiv5A75LDDm4-JXSYQIhwDFcUAlQ', null, '123456', 'qqq', '2019-12-18 13:08:58', '1');
INSERT INTO `picture` VALUES ('6', ',Fpgbx-zLUYGjv164zL9zzKdOAcWo', null, '21234', 'qqq', '2019-12-18 13:11:23', '4');
INSERT INTO `picture` VALUES ('13', ',Fhj4VbyknayGRGREJEHelR5Yzmz2', null, '苹果', '水果', '2019-12-27 12:17:44', '2');
INSERT INTO `picture` VALUES ('14', ',FokQed5uqjnWSoyf8TuexFHxpyeZ', null, '123456', 'qqq', '2019-12-27 12:18:37', '2');
INSERT INTO `picture` VALUES ('15', ',FtPZL-oPfr-CIKs3bDnhOwSQM46q', null, 'e21', 'qqq', '2019-12-27 12:18:50', '2');
INSERT INTO `picture` VALUES ('16', ',Fpgbx-zLUYGjv164zL9zzKdOAcWo', null, '21234', '风景', '2019-12-27 12:20:51', '2');
INSERT INTO `picture` VALUES ('20', ',FtPZL-oPfr-CIKs3bDnhOwSQM46q', null, 'admin', '风景', '2020-01-01 10:20:03', '4');
INSERT INTO `picture` VALUES ('21', ',FnrJvMSqJIHvIkEF8sewSNWEVI9n', null, '123456', '水果', '2020-01-01 10:20:14', '4');
INSERT INTO `picture` VALUES ('22', ',FlSbiCdwvIlVWMo96919deLOWuk8', null, '小和山的春天', '风景', '2020-01-01 10:20:32', '4');
INSERT INTO `picture` VALUES ('23', ',Fiv5A75LDDm4-JXSYQIhwDFcUAlQ', null, '苹果', '水果', '2020-01-02 18:53:43', '4');
INSERT INTO `picture` VALUES ('24', ',Fpgbx-zLUYGjv164zL9zzKdOAcWo', null, '123456', 'aaa', '2020-01-02 18:54:03', '4');
INSERT INTO `picture` VALUES ('25', ',Fi5ROphbhSCJJSZtvrvRniX9Hu8Y', null, 'admin', '风景', '2020-01-02 19:02:16', '2');
INSERT INTO `picture` VALUES ('26', ',FtPZL-oPfr-CIKs3bDnhOwSQM46q,FnrJvMSqJIHvIkEF8sewSNWEVI9n', null, 'admin', '风景', '2020-01-02 19:11:41', '3');
INSERT INTO `picture` VALUES ('28', ',Fpgbx-zLUYGjv164zL9zzKdOAcWo', null, 'admin', '风景', '2020-01-03 08:34:06', '2');
INSERT INTO `picture` VALUES ('29', ',FtPZL-oPfr-CIKs3bDnhOwSQM46q', null, '123456', '水果', '2020-01-03 08:35:00', '2');
INSERT INTO `picture` VALUES ('30', ',FtPZL-oPfr-CIKs3bDnhOwSQM46q', null, 'admin', '风景', '2020-01-03 10:48:31', '5');
INSERT INTO `picture` VALUES ('31', ',Fpgbx-zLUYGjv164zL9zzKdOAcWo', null, 'e21', '水果', '2020-01-03 10:48:43', '5');
INSERT INTO `picture` VALUES ('32', ',Fs9Ma0soWRmkeG__2iD4ursRvCGL', null, '123456', 'aaa', '2020-01-03 10:48:53', '5');

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_url` varchar(255) DEFAULT NULL,
  `parent_id` smallint(6) DEFAULT NULL,
  `res_key` varchar(255) DEFAULT NULL,
  `res_name` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', null, null, 'system', '系统管理', '');
INSERT INTO `resource` VALUES ('2', '/system/member', '1', 'system-member', '用户管理', '');
INSERT INTO `resource` VALUES ('3', '/system/resource', '1', 'system-resource', '资源管理', '');
INSERT INTO `resource` VALUES ('4', '/system/concerner/list', '1', 'system-concerner', '关注的用户管理', '');
INSERT INTO `resource` VALUES ('5', '/system/concernerimage', '1', 'system-concernerimage', '关注的用户照片管理', '');
INSERT INTO `resource` VALUES ('6', '/system/allimage/list', '1', 'system-allimage', '所有用户照片查看', '');
INSERT INTO `resource` VALUES ('7', '/system/person/list', '1', 'system-person', '个人信息管理', '');
INSERT INTO `resource` VALUES ('8', '/system/changepassword', '1', 'system-changepassword', '修改密码', '');
INSERT INTO `resource` VALUES ('9', '/system/upload', '1', 'system-upload', '上传图片', '');
INSERT INTO `resource` VALUES ('10', '/system/complaintmanage/list', '1', 'system-complaintmanage', '投诉管理', '');
INSERT INTO `resource` VALUES ('11', '/system/complaint', '1', 'system-complaint', '提交投诉', '');
INSERT INTO `resource` VALUES ('12', '/system/modifyperson', '1', 'system-modifyperson', '修改个人信息', '');
INSERT INTO `resource` VALUES ('13', '/system/black', '1', 'system-black', '查看黑名单', '');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', '管理员', '');
INSERT INTO `role` VALUES ('2', '用户', '用户', '');
INSERT INTO `role` VALUES ('3', '系统管理员', '系统管理员', '');

-- ----------------------------
-- Table structure for t_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_role_resource`;
CREATE TABLE `t_role_resource` (
  `role_id` int(11) NOT NULL,
  `resource_id` int(11) NOT NULL,
  KEY `FK1rr5hduurdi3albnmmbpmpp6r` (`resource_id`),
  KEY `FKais27ji26hco493atdsu9gyns` (`role_id`),
  CONSTRAINT `FK1rr5hduurdi3albnmmbpmpp6r` FOREIGN KEY (`resource_id`) REFERENCES `resource` (`id`),
  CONSTRAINT `FKais27ji26hco493atdsu9gyns` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_resource
-- ----------------------------
INSERT INTO `t_role_resource` VALUES ('1', '2');
INSERT INTO `t_role_resource` VALUES ('1', '3');
INSERT INTO `t_role_resource` VALUES ('1', '4');
INSERT INTO `t_role_resource` VALUES ('1', '5');
INSERT INTO `t_role_resource` VALUES ('1', '6');
INSERT INTO `t_role_resource` VALUES ('1', '7');
INSERT INTO `t_role_resource` VALUES ('1', '8');
INSERT INTO `t_role_resource` VALUES ('1', '9');
INSERT INTO `t_role_resource` VALUES ('1', '10');
INSERT INTO `t_role_resource` VALUES ('1', '11');
INSERT INTO `t_role_resource` VALUES ('2', '4');
INSERT INTO `t_role_resource` VALUES ('2', '6');
INSERT INTO `t_role_resource` VALUES ('2', '7');
INSERT INTO `t_role_resource` VALUES ('2', '8');
INSERT INTO `t_role_resource` VALUES ('2', '9');
INSERT INTO `t_role_resource` VALUES ('2', '12');
INSERT INTO `t_role_resource` VALUES ('3', '2');
INSERT INTO `t_role_resource` VALUES ('3', '3');
INSERT INTO `t_role_resource` VALUES ('3', '10');
INSERT INTO `t_role_resource` VALUES ('2', '11');
INSERT INTO `t_role_resource` VALUES ('2', '13');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FKjwwimwt7mcivvbosl7rms6q4y` (`role_id`),
  KEY `FKm61t2kt35dkh35mbd8t0wjisl` (`user_id`),
  CONSTRAINT `FKjwwimwt7mcivvbosl7rms6q4y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKm61t2kt35dkh35mbd8t0wjisl` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1');
INSERT INTO `t_user_role` VALUES ('2', '2');
INSERT INTO `t_user_role` VALUES ('3', '3');
INSERT INTO `t_user_role` VALUES ('4', '2');
INSERT INTO `t_user_role` VALUES ('5', '2');
INSERT INTO `t_user_role` VALUES ('6', '2');
INSERT INTO `t_user_role` VALUES ('7', '2');
INSERT INTO `t_user_role` VALUES ('8', '2');
INSERT INTO `t_user_role` VALUES ('9', '2');
INSERT INTO `t_user_role` VALUES ('10', '2');
INSERT INTO `t_user_role` VALUES ('11', '2');

-- ----------------------------
-- Table structure for tags
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tags
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `QQ` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` smallint(6) DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `regist_time` datetime DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1132507085', '浙江', '1132507085@qq.com', '1', '111', '13588891715', '0000', '杭州', 'rnzhiw', '2019-12-18 12:48:28', '1', '1', 'rnzhiw123', null);
INSERT INTO `user` VALUES ('2', 'ndg', '台州', 'rnzhiw@163.com', '1', '111', '13588888888', '123', '浙江', '张三CTO', '2019-12-18 12:50:54', '1', '0', '战三', ',Fi5ROphbhSCJJSZtvrvRniX9Hu8Y');
INSERT INTO `user` VALUES ('3', '113255555', '浙江', 'rnzhiw@qq.com', '1', '111', '13588891714', '0000', '台州', 'rnzhiww', '2019-12-18 12:51:58', '1', '0', 'rnzhiw', ',Fiv5A75LDDm4-JXSYQIhwDFcUAlQ');
INSERT INTO `user` VALUES ('4', '123', '浙江', '111@qq.com', '1', '111', '123456', '0000', '杭州', '123', '2019-12-18 12:52:58', '1', '0', '123', ',Fhj4VbyknayGRGREJEHelR5Yzmz2');
INSERT INTO `user` VALUES ('5', '234', '浙江', '123@qq.com', null, null, '234', '0000', '黑龙江', '234', '2019-12-26 14:41:02', '1', '0', '234', ',Fs9Ma0soWRmkeG__2iD4ursRvCGL');
INSERT INTO `user` VALUES ('6', '345', null, '123@qq.com', null, null, '345', '0000', '中国', null, '2019-12-26 14:41:04', '1', '0', '345', null);
INSERT INTO `user` VALUES ('7', '456', null, '123@qq.com', null, null, '456', '0000', '美国', null, null, '1', '0', '456', null);
INSERT INTO `user` VALUES ('8', '567', null, '123@qq.com', null, null, '567', '0000', '欧洲', null, null, '1', '0', '567', null);
INSERT INTO `user` VALUES ('9', '678', null, '123@qq.com', null, null, '678', '0000', '大洋洲', null, null, '1', '0', '678', null);
INSERT INTO `user` VALUES ('10', '789', null, '123@qq.com', null, null, '789', '0000', '英国', null, null, '1', '0', '789', null);
INSERT INTO `user` VALUES ('11', '321', null, '123@qq.com', null, null, '321', '0000', '法国', null, null, '1', '0', '321', null);
