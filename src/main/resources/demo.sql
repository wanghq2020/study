/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-05-28 08:53:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `deilvery`
-- ----------------------------
DROP TABLE IF EXISTS `deilvery`;
CREATE TABLE `deilvery` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(64) NOT NULL COMMENT '主订单id',
  `order_detail_id` bigint(64) NOT NULL COMMENT '子订单id',
  `deilvery_quantity` decimal(64,6) NOT NULL COMMENT '发货数量',
  `is_deilvery` int(2) NOT NULL DEFAULT '0' COMMENT '是否已发货（0 未发货  1 已发货）',
  `version` int(11) NOT NULL DEFAULT '1' COMMENT '版本号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deilvery
-- ----------------------------
INSERT INTO `deilvery` VALUES ('2', '1', '1', '12.000000', '0', '1', '2020-05-28 08:29:00', '2020-05-28 08:44:30');
INSERT INTO `deilvery` VALUES ('3', '1', '1', '12.000000', '0', '1', '2020-05-28 08:29:40', '2020-05-28 08:44:32');
INSERT INTO `deilvery` VALUES ('4', '1', '1', '24.000000', '0', '2', '2020-05-28 08:48:44', '2020-05-28 08:48:44');
INSERT INTO `deilvery` VALUES ('5', '1', '1', '20.000000', '0', '2', '2020-05-28 08:49:36', '2020-05-28 08:49:36');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `goods_type` bigint(64) NOT NULL COMMENT '商品类型id',
  `goods_name` varchar(255) NOT NULL COMMENT '商品名称',
  `stocks` int(11) NOT NULL COMMENT '库存量',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '12', '夏裙', '10000', '2020-05-28 07:45:58', '2020-05-28 07:45:58');

-- ----------------------------
-- Table structure for `logistics`
-- ----------------------------
DROP TABLE IF EXISTS `logistics`;
CREATE TABLE `logistics` (
  `id` bigint(64) NOT NULL,
  `deilvery_id` bigint(64) NOT NULL COMMENT '发货单id',
  `logistics_info_code` varchar(255) NOT NULL COMMENT '物流信息code',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logistics
-- ----------------------------

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(64) NOT NULL COMMENT '会员id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '收货人姓名',
  `mobile` varchar(25) DEFAULT NULL COMMENT '收货电话',
  `address` varchar(255) DEFAULT NULL COMMENT '收货地址',
  `remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '2', '张三', '15607892463', '上海市闵行区七宝', null, '2020-05-28 07:47:00', '2020-05-28 07:47:00');

-- ----------------------------
-- Table structure for `order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(64) NOT NULL COMMENT '主订单表id',
  `goods_id` bigint(64) NOT NULL COMMENT '商品id',
  `order_quantity` decimal(64,6) NOT NULL COMMENT '订单数量',
  `remaining_quantity` decimal(64,6) NOT NULL COMMENT '剩余待发货数量',
  `price` decimal(64,6) NOT NULL COMMENT '商品价格',
  `version` int(11) NOT NULL DEFAULT '1' COMMENT '版本号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('1', '1', '1', '60.000000', '16.000000', '56.000000', '2', '2020-05-28 07:47:42', '2020-05-28 08:49:36');
