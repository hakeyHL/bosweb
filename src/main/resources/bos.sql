/*
Navicat MySQL Data Transfer

Source Server         : 101.200.54.205
Source Server Version : 50716
Source Host           : 101.200.54.205:3306
Source Database       : bos

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-03-20 23:48:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE "car" (
  "id" int(11) NOT NULL AUTO_INCREMENT COMMENT '主键,自增',
  "model" varchar(255) DEFAULT NULL COMMENT '车的型号',
  "brand" varchar(255) DEFAULT NULL COMMENT '车的品牌',
  "number" varchar(255) DEFAULT NULL COMMENT '车牌号',
  PRIMARY KEY ("id")
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('1', '华晨', '宝马', '皖S114456');
INSERT INTO `car` VALUES ('2', 'M', '宝马', '皖S114454');

-- ----------------------------
-- Table structure for courier
-- ----------------------------
DROP TABLE IF EXISTS `courier`;
CREATE TABLE "courier" (
  "id" int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id,自增',
  "name" varchar(255) DEFAULT NULL,
  "region" varchar(255) DEFAULT NULL COMMENT '此快递员负责的配送区域',
  PRIMARY KEY ("id")
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of courier
-- ----------------------------
INSERT INTO `courier` VALUES ('1', '李丽', '张家窝');
INSERT INTO `courier` VALUES ('2', '张丽', '杨柳青');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE "order" (
  "id" int(11) NOT NULL AUTO_INCREMENT COMMENT '主键,自增',
  "sender" varchar(255) DEFAULT NULL COMMENT '发件人',
  "receiver" varchar(255) DEFAULT NULL COMMENT '收件人',
  "senderPhone" varchar(255) DEFAULT NULL COMMENT '发件人手机号',
  "receiverPhone" varchar(255) DEFAULT NULL COMMENT '收件人手机号',
  "senderAddress" varchar(255) DEFAULT NULL COMMENT '发货地址',
  "receiverAddress" varchar(255) DEFAULT NULL COMMENT '收货地址',
  "postCode" varchar(255) DEFAULT NULL COMMENT '邮编',
  "createTime" datetime DEFAULT NULL COMMENT '订单创建时间',
  "updateTime" datetime DEFAULT NULL COMMENT '订单更新时间',
  "courierId" int(11) DEFAULT NULL COMMENT '配送员id',
  "carNumber" int(11) DEFAULT NULL COMMENT '配送车辆id',
  "show" int(11) DEFAULT '1' COMMENT '订单是否可见 1 值为默认值表示可见, 0 表示不可见',
  PRIMARY KEY ("id")
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '张明', '李四', '13022250667', '15620094567', '天津西青', '北京朝阳', '00000', '2017-03-20 22:59:26', '2017-03-20 22:59:32', '1', '1', '1');
