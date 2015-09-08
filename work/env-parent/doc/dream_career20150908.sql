/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50520
Source Host           : 127.0.0.1:3306
Source Database       : dream_career

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2015-09-08 23:44:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `drm_company`
-- ----------------------------
DROP TABLE IF EXISTS `drm_company`;
CREATE TABLE `drm_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `company_index` int(11) DEFAULT NULL COMMENT '公司顺序，1当前2上一家3上上一家...',
  `company_name` varchar(200) DEFAULT NULL COMMENT '公司名称',
  `company_shotname` varchar(100) DEFAULT NULL COMMENT '公司简称',
  `dept_name` varchar(200) DEFAULT NULL COMMENT '部门名称',
  `postname` varchar(100) DEFAULT NULL COMMENT '我的岗位名称（预留）',
  `job_duration` varchar(100) DEFAULT NULL COMMENT '在职时长',
  `provide_content` varchar(4000) DEFAULT NULL COMMENT '提供的信息',
  `word_count` int(11) DEFAULT NULL COMMENT '公司信息字数统计（预留）',
  `qq` int(11) DEFAULT '1' COMMENT '是否提供QQ方式（预留）',
  `weixin` int(11) DEFAULT '1' COMMENT '是否提供weixin方式（预留）',
  `phone` int(11) DEFAULT '1' COMMENT '是否提供电话方式（预留）',
  `email` int(11) DEFAULT '1' COMMENT '是否提供email方式（预留）',
  `zhanneixin` int(11) DEFAULT '1' COMMENT '是否提供站内信方式（预留）',
  `ptshow` int(11) DEFAULT '1' COMMENT '直接在平台展示（预留）',
  `price` decimal(18,6) DEFAULT '0.000000' COMMENT '标价',
  `faceprice` decimal(18,6) DEFAULT NULL COMMENT '线下服务价格（预留）',
  `remark` varchar(4000) DEFAULT NULL COMMENT '备注信息',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `disabled` int(11) DEFAULT '0' COMMENT '逻辑删除标志，1删除0可用',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改者id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='用户注册的公司信息';

-- ----------------------------
-- Records of drm_company
-- ----------------------------
INSERT INTO `drm_company` VALUES ('44', '1', '1', null, '测试公司1', '1', null, '请选择', '', null, '3411', null, null, null, null, null, null, null, '', null, null, null, null, null, null);
INSERT INTO `drm_company` VALUES ('45', '2', '1', null, '途牛', '', null, '请选择', '，业务方向，部门信息，男女员工大概比例，公司文化', null, null, null, null, null, null, null, null, null, '', null, null, null, null, null, null);
INSERT INTO `drm_company` VALUES ('46', '3', '1', null, '途牛公司', null, null, null, null, null, '1', '1', '1', '1', '1', '1', '0.000000', null, null, null, '0', null, null, null, null);
INSERT INTO `drm_company` VALUES ('47', '4', '1', null, '途牛', null, null, null, null, null, '1', '1', '1', '1', '1', '1', '0.000000', null, null, null, '0', null, null, null, null);
INSERT INTO `drm_company` VALUES ('48', '5', '1', null, '途牛旅游网', null, null, null, null, null, '1', '1', '1', '1', '1', '1', '0.000000', null, null, null, '0', null, null, null, null);
INSERT INTO `drm_company` VALUES ('49', '5', '2', null, '苏宁', null, null, null, null, null, '1', '1', '1', '1', '1', '1', '0.000000', null, null, null, '0', null, null, null, null);

-- ----------------------------
-- Table structure for `drm_company_lib`
-- ----------------------------
DROP TABLE IF EXISTS `drm_company_lib`;
CREATE TABLE `drm_company_lib` (
  `id` int(11) NOT NULL,
  `company_name` varchar(200) DEFAULT NULL COMMENT '公司全称',
  `company_shotname` varchar(100) DEFAULT NULL COMMENT '公司简称',
  `website` varchar(500) DEFAULT NULL COMMENT '公司门户网址',
  `employee_sum` varchar(50) DEFAULT NULL COMMENT '公司规模',
  `city` varchar(100) DEFAULT NULL COMMENT '公司所在城市',
  `establish_date` date DEFAULT NULL COMMENT '公司创建时间',
  `introduction` varchar(4000) DEFAULT NULL COMMENT '公司简介',
  `fields` varchar(2000) DEFAULT NULL COMMENT '专长领域',
  `contact_usernum` int(11) DEFAULT NULL COMMENT '已收录的员工数',
  `remark` varchar(500) DEFAULT NULL,
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `disabled` int(11) DEFAULT '0' COMMENT '逻辑删除标志，1删除0可用',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改者id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司库，搜索使用';

-- ----------------------------
-- Records of drm_company_lib
-- ----------------------------

-- ----------------------------
-- Table structure for `drm_complain`
-- ----------------------------
DROP TABLE IF EXISTS `drm_complain`;
CREATE TABLE `drm_complain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `complain_reason` varchar(1000) DEFAULT NULL COMMENT '投诉原因',
  `remark` varchar(4000) DEFAULT NULL,
  `send_user_id` int(11) DEFAULT NULL,
  `receive_user_id` int(11) DEFAULT NULL,
  `money_count` varchar(500) DEFAULT NULL COMMENT '收款账号',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  `disabled` int(11) DEFAULT '0' COMMENT '逻辑删除标志，1删除0可用',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改者id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投诉';

-- ----------------------------
-- Records of drm_complain
-- ----------------------------

-- ----------------------------
-- Table structure for `drm_dept`
-- ----------------------------
DROP TABLE IF EXISTS `drm_dept`;
CREATE TABLE `drm_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `company_id` int(11) DEFAULT NULL COMMENT '我的公司ID',
  `company_name` varchar(200) DEFAULT NULL COMMENT '公司名称',
  `dept_name` varchar(200) DEFAULT NULL COMMENT '部门名称',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `disabled` int(11) DEFAULT '0' COMMENT '逻辑删除标志，1删除0可用',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改者id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='用户注册的部门信息';

-- ----------------------------
-- Records of drm_dept
-- ----------------------------
INSERT INTO `drm_dept` VALUES ('9', null, '10', 'a', '', null, '1', null, null, null, '2015-05-14 18:03:14');
INSERT INTO `drm_dept` VALUES ('10', null, '11', 'a', '', null, '1', null, null, null, '2015-05-14 23:12:38');
INSERT INTO `drm_dept` VALUES ('11', null, '12', 'a', 'a', null, '1', null, null, null, '2015-05-14 18:09:18');
INSERT INTO `drm_dept` VALUES ('12', null, '13', 'a', '', null, '1', null, null, null, '2015-05-14 23:12:43');
INSERT INTO `drm_dept` VALUES ('13', null, '14', '2', '', null, '1', null, null, null, '2015-05-14 21:17:43');
INSERT INTO `drm_dept` VALUES ('14', null, '15', 'as', '', null, '0', null, null, null, null);
INSERT INTO `drm_dept` VALUES ('15', null, '16', 'xxx', '', null, '0', null, null, null, null);
INSERT INTO `drm_dept` VALUES ('26', null, '16', 'ssssss', '', null, '0', null, null, null, null);
INSERT INTO `drm_dept` VALUES ('28', null, '18', 'abcd', '', null, '1', null, null, null, '2015-05-20 17:57:48');
INSERT INTO `drm_dept` VALUES ('29', null, '19', 'rrrrrrrrrrrrrrr', '', null, '0', null, null, null, null);
INSERT INTO `drm_dept` VALUES ('30', null, '20', 'a', '', null, '1', null, null, null, '2015-05-21 09:38:39');
INSERT INTO `drm_dept` VALUES ('31', null, '21', 'xxx', '', null, '1', null, null, null, '2015-05-21 14:11:27');

-- ----------------------------
-- Table structure for `drm_help_info`
-- ----------------------------
DROP TABLE IF EXISTS `drm_help_info`;
CREATE TABLE `drm_help_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(200) DEFAULT NULL COMMENT '目标公司',
  `nickname` varchar(100) DEFAULT NULL COMMENT '昵称',
  `contact_type` varchar(100) DEFAULT NULL COMMENT '联系方式',
  `ope_time` datetime DEFAULT NULL,
  `eval_content` varchar(4000) DEFAULT NULL COMMENT '评价内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='TA们都在这里得到了帮助，模拟数据';

-- ----------------------------
-- Records of drm_help_info
-- ----------------------------

-- ----------------------------
-- Table structure for `drm_letter`
-- ----------------------------
DROP TABLE IF EXISTS `drm_letter`;
CREATE TABLE `drm_letter` (
  `id` int(11) NOT NULL,
  `title` varchar(2000) DEFAULT NULL COMMENT '私信标题',
  `content` varchar(4000) DEFAULT NULL COMMENT '私信内容',
  `send_userid` int(11) DEFAULT NULL COMMENT '发送人id',
  `send_username` varchar(200) DEFAULT NULL COMMENT '发送人姓名',
  `receive_userid` int(11) DEFAULT NULL COMMENT '接收人id',
  `receive_username` varchar(200) DEFAULT NULL COMMENT '接收人姓名',
  `send_time` datetime DEFAULT NULL COMMENT '发送时间',
  `readed` int(11) DEFAULT '0' COMMENT '0未读1已读',
  `version` int(11) DEFAULT '0' COMMENT '记录版本号，每次修改递增1',
  `disabled` int(1) DEFAULT '0' COMMENT '逻辑删除标志，1删除0可用',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改者ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of drm_letter
-- ----------------------------

-- ----------------------------
-- Table structure for `drm_pay_notice`
-- ----------------------------
DROP TABLE IF EXISTS `drm_pay_notice`;
CREATE TABLE `drm_pay_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `req_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL COMMENT '付款用户id',
  `user_phone` varchar(20) DEFAULT NULL COMMENT '付款用户手机号',
  `receive_user_id` int(11) DEFAULT NULL COMMENT '收钱的用户id',
  `money` decimal(18,6) DEFAULT NULL COMMENT '付款金额（预留）',
  `company_id` int(11) DEFAULT NULL,
  `company_name` varchar(200) DEFAULT NULL,
  `notice_type` int(11) DEFAULT '1' COMMENT '通知类型：1赏金托管完成通知，2服务完成确认付款通知',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  `disabled` int(11) DEFAULT '0' COMMENT '逻辑删除标志，1删除0可用',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改者id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='付款通知';

-- ----------------------------
-- Records of drm_pay_notice
-- ----------------------------
INSERT INTO `drm_pay_notice` VALUES ('3', '14', '4', '132', '1', '100.000000', null, '途牛', '1', null, '0', null, '2015-09-08 23:00:28', null, null);
INSERT INTO `drm_pay_notice` VALUES ('4', '14', '4', '132', '1', '100.000000', null, '途牛', '1', null, '0', null, '2015-09-08 23:02:31', null, null);
INSERT INTO `drm_pay_notice` VALUES ('5', '16', '4', '132', '1', '50.000000', null, '途牛', '2', null, '0', null, '2015-09-08 23:02:55', null, null);
INSERT INTO `drm_pay_notice` VALUES ('6', '16', '4', '132', '1', '50.000000', null, '途牛', '2', null, '0', null, '2015-09-08 23:03:30', null, null);
INSERT INTO `drm_pay_notice` VALUES ('7', '13', '4', '132', '4', '100.000000', null, '途牛', '1', null, '0', null, '2015-09-08 23:34:16', null, null);

-- ----------------------------
-- Table structure for `drm_req`
-- ----------------------------
DROP TABLE IF EXISTS `drm_req`;
CREATE TABLE `drm_req` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `req_num` varchar(100) DEFAULT NULL COMMENT '需求订单编号(根据规则生成）',
  `company_name` varchar(200) DEFAULT NULL COMMENT '公司名称',
  `company_shotname` varchar(100) DEFAULT NULL COMMENT '公司简称',
  `price` decimal(18,6) DEFAULT NULL COMMENT '赏金',
  `faceprice` decimal(18,6) DEFAULT NULL COMMENT '线下服务赏金',
  `send_user_id` int(11) DEFAULT NULL COMMENT '发布需求的用户id',
  `send_user_phone` varchar(20) DEFAULT NULL COMMENT '发布需求的用户手机号',
  `send_user_nickname` varchar(100) DEFAULT NULL COMMENT '发布需求的用户昵称',
  `accept_state` int(11) DEFAULT '0' COMMENT '应答状态0未应答1已应答2赏金已托管3服务已完成4申请退款5放弃需求6确认将赏金转给对方7重新发起需求',
  `accept_user_id` int(11) DEFAULT NULL COMMENT '应答的用户id',
  `accept_duration` varchar(2000) DEFAULT NULL COMMENT '方便的时间段，例如工作日，节假日，均可。直接是存储汉字',
  `open_contact` varchar(2000) DEFAULT NULL COMMENT '开放给对方的联系方式，例如电话qq邮箱',
  `accept_time` datetime DEFAULT NULL COMMENT '应答时间',
  `deposit_time` datetime DEFAULT NULL COMMENT '赏金托管时间',
  `complete_time` datetime DEFAULT NULL COMMENT '服务完成时间',
  `end_time` datetime DEFAULT NULL COMMENT '评价结束时间',
  `stop_time` datetime DEFAULT NULL COMMENT '废弃终止时间(放弃帮助时间）',
  `apply_backmoney_time` datetime DEFAULT NULL COMMENT '申请退款时间',
  `pay_time` datetime DEFAULT NULL COMMENT '确认付款给对方的时间',
  `again_release_time` datetime DEFAULT NULL COMMENT '重新发起需求时间',
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `content` varchar(4000) DEFAULT NULL COMMENT '详细需求(捎上一句话）',
  `overtime` datetime DEFAULT NULL COMMENT '过期时间（默认一个月）',
  `eval_score` int(11) DEFAULT NULL COMMENT '评价分数',
  `eval_content` varchar(4000) DEFAULT NULL COMMENT '评价内容',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  `disabled` int(11) DEFAULT '0' COMMENT '逻辑删除标志，1删除0可用',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间(需求发布时间）',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改者id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='需求';

-- ----------------------------
-- Records of drm_req
-- ----------------------------
INSERT INTO `drm_req` VALUES ('2', null, null, '测试', '1.000000', null, null, null, null, '0', null, null, null, null, null, null, null, null, null, null, null, null, '的双方各', null, null, null, null, '0', null, null, null, null);
INSERT INTO `drm_req` VALUES ('3', null, null, '测试公司1', '1.000000', null, null, null, null, '1', null, null, null, null, null, null, null, null, null, null, null, null, '111', null, null, null, null, '0', null, null, null, null);
INSERT INTO `drm_req` VALUES ('4', null, null, '测试公司1', '1.000000', null, null, null, null, '1', '1', '工作日,周末及节假日,', '手机号,QQ号码,电子邮箱', '2015-09-07 15:29:31', null, null, null, null, null, null, null, null, '水电费', null, null, null, null, '0', null, null, null, '2015-09-07 15:29:32');
INSERT INTO `drm_req` VALUES ('5', null, null, 'sdf', '324.000000', null, '8', '150', null, '3', null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, '0', null, '2015-09-02 11:16:52', null, null);
INSERT INTO `drm_req` VALUES ('6', null, null, 'sdf', '1.000000', null, '9', '1', null, '4', null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, '0', null, '2015-09-02 11:19:31', null, null);
INSERT INTO `drm_req` VALUES ('7', null, null, '34', '3.000000', null, '10', '3', null, '1', null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, null, null, '0', null, '2015-09-02 11:20:46', null, null);
INSERT INTO `drm_req` VALUES ('8', null, null, '1', '1.000000', null, '8', '150', null, '1', '1', null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, '0', null, '2015-09-02 12:10:18', null, null);
INSERT INTO `drm_req` VALUES ('9', null, null, '1', '1.000000', null, '9', '1', null, '2', '1', null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, '0', null, '2015-09-02 12:12:00', null, null);
INSERT INTO `drm_req` VALUES ('10', null, null, '1', '1.000000', null, '8', '150', null, '3', '1', null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, '0', null, '2015-09-02 12:28:00', null, null);
INSERT INTO `drm_req` VALUES ('11', null, null, 'test', '1.000000', null, '11', '188', null, '2', null, null, null, null, null, null, null, null, null, null, null, null, '111', null, null, null, null, '0', null, '2015-09-02 13:54:09', null, null);
INSERT INTO `drm_req` VALUES ('12', null, null, '1', '11.000000', null, '12', '11', null, '5', '1', null, null, null, null, null, null, null, null, null, null, null, '111', null, null, null, null, '0', null, '2015-09-02 13:55:51', null, null);
INSERT INTO `drm_req` VALUES ('13', null, null, '途牛', '100.000000', null, '4', '132', '132途牛用户', '1', '4', '工作日,周末及节假日,测试啦啦啦', '手机号,QQ号码,电子邮箱', '2015-09-08 23:33:54', null, null, null, null, null, null, null, null, '1', null, null, null, null, '0', null, '2015-09-02 15:04:13', null, '2015-09-08 23:33:54');
INSERT INTO `drm_req` VALUES ('14', null, null, '途牛', '100.000000', null, '4', '132', '132途牛用户', '1', '4', null, null, null, '2015-09-08 22:33:01', null, null, '2015-09-08 17:42:59', null, null, null, null, '1', null, null, null, null, '0', null, '2015-09-02 15:09:39', null, '2015-09-08 22:33:02');
INSERT INTO `drm_req` VALUES ('15', null, null, '途牛', '100.000000', null, '4', '132', '132途牛用户', '2', '4', null, null, null, null, '2015-09-08 16:43:01', null, null, null, '2015-09-08 17:23:20', null, null, '1', null, null, null, null, '0', null, '2015-09-02 15:13:37', null, '2015-09-08 17:23:20');
INSERT INTO `drm_req` VALUES ('16', null, null, '途牛', '50.000000', '1.000000', '4', '132', '130途牛用户', '6', '4', null, null, null, null, null, null, null, null, '2015-09-08 23:03:30', null, null, '1', null, null, null, null, '0', null, '2015-09-02 15:57:15', null, '2015-09-08 23:03:30');
INSERT INTO `drm_req` VALUES ('17', null, null, '途牛', '100.000000', null, '4', '132', '132途牛用户', '4', '4', null, null, null, null, null, null, null, null, null, null, null, '备注备注备注备注备注备注', null, null, null, null, '0', null, '2015-09-02 16:22:09', null, null);
INSERT INTO `drm_req` VALUES ('18', null, null, '苏宁', '50.000000', null, '4', '132', '132途牛用户', '5', '4', null, null, null, null, null, null, null, null, null, '2015-09-08 17:41:04', null, '1', null, null, null, null, '0', null, '2015-09-02 16:36:07', null, '2015-09-08 17:41:04');
INSERT INTO `drm_req` VALUES ('19', null, null, '苏宁', '50.000000', null, '4', '132', '133途牛苏宁用户', '6', '4', null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, '0', null, '2015-09-02 16:37:20', null, null);
INSERT INTO `drm_req` VALUES ('20', null, null, '苏宁', '50.000000', null, '4', '132', '132途牛用户', '7', '4', null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, '0', null, '2015-09-02 16:38:11', null, null);
INSERT INTO `drm_req` VALUES ('21', null, null, '苏宁', '50.000000', null, '2', '130', '130途牛用户', '1', null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, '0', null, '2015-09-02 16:46:14', null, null);
INSERT INTO `drm_req` VALUES ('22', null, null, '苏宁', '50.000000', null, '2', '130', '130途牛用户', '2', null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, '0', null, '2015-09-07 13:54:59', null, null);

-- ----------------------------
-- Table structure for `drm_req_notice`
-- ----------------------------
DROP TABLE IF EXISTS `drm_req_notice`;
CREATE TABLE `drm_req_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `req_id` int(11) DEFAULT NULL COMMENT 'drm_req表的注解',
  `send_user_id` int(11) DEFAULT NULL COMMENT '发布需求的用户id',
  `receive_user_id` int(11) DEFAULT NULL COMMENT '匹配到需求的用户id',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  `disabled` int(11) DEFAULT '0' COMMENT '逻辑删除标志，1删除0可用',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间(需求发布时间）',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改者id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='给哪些用户发需求通知，我接收到的需求';

-- ----------------------------
-- Records of drm_req_notice
-- ----------------------------
INSERT INTO `drm_req_notice` VALUES ('1', '4', '7', '2', null, null, null, null, null, null);
INSERT INTO `drm_req_notice` VALUES ('2', '8', '8', '2', null, '0', null, '2015-09-02 12:10:18', null, null);
INSERT INTO `drm_req_notice` VALUES ('3', '8', '8', '7', null, '0', null, '2015-09-02 12:10:18', null, null);
INSERT INTO `drm_req_notice` VALUES ('4', '9', '9', '2', null, '0', null, '2015-09-02 12:12:00', null, null);
INSERT INTO `drm_req_notice` VALUES ('5', '9', '9', '7', null, '0', null, '2015-09-02 12:12:00', null, null);
INSERT INTO `drm_req_notice` VALUES ('6', '10', '8', '2', null, '0', null, '2015-09-02 12:28:01', null, null);
INSERT INTO `drm_req_notice` VALUES ('7', '10', '8', '7', null, '0', null, '2015-09-02 12:28:01', null, null);
INSERT INTO `drm_req_notice` VALUES ('8', '12', '12', '2', null, '0', null, '2015-09-02 13:55:51', null, null);
INSERT INTO `drm_req_notice` VALUES ('9', '12', '12', '7', null, '0', null, '2015-09-02 13:55:51', null, null);
INSERT INTO `drm_req_notice` VALUES ('10', '13', '4', '1', null, '0', null, '2015-09-02 15:04:14', null, null);
INSERT INTO `drm_req_notice` VALUES ('11', '13', '4', '3', null, '0', null, '2015-09-02 15:04:14', null, null);
INSERT INTO `drm_req_notice` VALUES ('12', '13', '4', '4', null, '0', null, '2015-09-02 15:04:14', null, null);
INSERT INTO `drm_req_notice` VALUES ('13', '14', '4', '1', null, '0', null, '2015-09-02 15:09:39', null, null);
INSERT INTO `drm_req_notice` VALUES ('14', '14', '4', '3', null, '0', null, '2015-09-02 15:09:39', null, null);
INSERT INTO `drm_req_notice` VALUES ('15', '14', '4', '4', null, '0', null, '2015-09-02 15:09:39', null, null);
INSERT INTO `drm_req_notice` VALUES ('16', '15', '4', '1', null, '0', null, '2015-09-02 15:13:37', null, null);
INSERT INTO `drm_req_notice` VALUES ('17', '15', '4', '3', null, '0', null, '2015-09-02 15:13:37', null, null);
INSERT INTO `drm_req_notice` VALUES ('18', '15', '4', '4', null, '0', null, '2015-09-02 15:13:37', null, null);
INSERT INTO `drm_req_notice` VALUES ('19', '16', '2', '1', null, '0', null, '2015-09-02 15:57:16', null, null);
INSERT INTO `drm_req_notice` VALUES ('20', '16', '2', '4', null, '0', null, '2015-09-02 15:57:16', null, null);
INSERT INTO `drm_req_notice` VALUES ('21', '16', '2', '5', null, '0', null, '2015-09-02 15:57:16', null, null);
INSERT INTO `drm_req_notice` VALUES ('22', '17', '4', '1', null, '0', null, '2015-09-02 16:22:09', null, null);
INSERT INTO `drm_req_notice` VALUES ('23', '17', '4', '3', null, '0', null, '2015-09-02 16:22:09', null, null);
INSERT INTO `drm_req_notice` VALUES ('24', '17', '4', '4', null, '0', null, '2015-09-02 16:22:10', null, null);
INSERT INTO `drm_req_notice` VALUES ('25', '20', '4', '4', null, '0', null, '2015-09-02 16:38:11', null, null);
INSERT INTO `drm_req_notice` VALUES ('26', '18', '4', '4', null, '0', null, '2015-09-02 16:46:14', null, null);
INSERT INTO `drm_req_notice` VALUES ('27', '19', '4', '4', null, '0', null, '2015-09-07 13:55:00', null, null);
INSERT INTO `drm_req_notice` VALUES ('28', '23', '4', '4', null, '0', null, '2015-09-07 17:15:55', null, null);
INSERT INTO `drm_req_notice` VALUES ('29', '24', '4', '5', null, '0', null, '2015-09-07 17:16:18', null, null);

-- ----------------------------
-- Table structure for `drm_search_company`
-- ----------------------------
DROP TABLE IF EXISTS `drm_search_company`;
CREATE TABLE `drm_search_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(200) DEFAULT NULL,
  `company_shotname` varchar(100) DEFAULT NULL,
  `searched` int(11) DEFAULT NULL,
  `send_user_id` int(11) DEFAULT NULL,
  `send_user_phone` varchar(20) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  `disabled` int(11) DEFAULT '0' COMMENT '逻辑删除标志，1删除0可用',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改者id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of drm_search_company
-- ----------------------------
INSERT INTO `drm_search_company` VALUES ('1', '34', '34', '0', '10', '3', '1', null, '0', null, '2015-09-02 11:20:46', null, null);
INSERT INTO `drm_search_company` VALUES ('2', '1', '1', '1', '8', '150', '1', null, '0', null, '2015-09-02 12:10:19', null, null);
INSERT INTO `drm_search_company` VALUES ('3', '1', '1', '1', '9', '1', '1', null, '0', null, '2015-09-02 12:12:00', null, null);
INSERT INTO `drm_search_company` VALUES ('4', '1', '1', '1', '8', '150', '1', null, '0', null, '2015-09-02 12:28:01', null, null);
INSERT INTO `drm_search_company` VALUES ('5', 'test', 'test', '0', '11', '188', '1', null, '0', null, '2015-09-02 13:54:09', null, null);
INSERT INTO `drm_search_company` VALUES ('6', '1', '1', '1', '12', '11', '1', null, '0', null, '2015-09-02 13:55:51', null, null);
INSERT INTO `drm_search_company` VALUES ('7', '途牛', '途牛', '1', '4', '132', '1', null, '0', null, '2015-09-02 15:04:14', null, null);
INSERT INTO `drm_search_company` VALUES ('8', '途牛', '途牛', '1', '4', '132', '1', null, '0', null, '2015-09-02 15:09:39', null, null);
INSERT INTO `drm_search_company` VALUES ('9', '途牛', '途牛', '1', '4', '132', '1', null, '0', null, '2015-09-02 15:13:37', null, null);
INSERT INTO `drm_search_company` VALUES ('10', '途牛', '途牛', '1', '2', '130', '1', null, '0', null, '2015-09-02 15:57:16', null, null);
INSERT INTO `drm_search_company` VALUES ('11', '途牛', '途牛', '1', '4', '132', '1', null, '0', null, '2015-09-02 16:22:10', null, null);
INSERT INTO `drm_search_company` VALUES ('12', '苏宁', '苏宁', '0', '5', '133', '1', null, '0', null, '2015-09-02 16:36:07', null, null);
INSERT INTO `drm_search_company` VALUES ('13', '苏宁', '苏宁', '0', '5', '133', '1', null, '0', null, '2015-09-02 16:37:37', null, null);
INSERT INTO `drm_search_company` VALUES ('14', '苏宁', '苏宁', '1', '11', '188', '1', null, '0', null, '2015-09-02 16:38:11', null, null);
INSERT INTO `drm_search_company` VALUES ('15', '苏宁', '苏宁', '1', '2', '130', '1', null, '0', null, '2015-09-02 16:46:14', null, null);
INSERT INTO `drm_search_company` VALUES ('16', '苏宁', '苏宁', '1', '2', '130', '1', null, '0', null, '2015-09-07 13:55:00', null, null);
INSERT INTO `drm_search_company` VALUES ('17', '苏宁', '苏宁', '1', '4', '132', '1', null, '0', null, '2015-09-07 17:15:55', null, null);
INSERT INTO `drm_search_company` VALUES ('18', '苏宁', '苏宁', '1', '4', '132', '1', null, '0', null, '2015-09-07 17:16:18', null, null);

-- ----------------------------
-- Table structure for `drm_search_record`
-- ----------------------------
DROP TABLE IF EXISTS `drm_search_record`;
CREATE TABLE `drm_search_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_id` int(11) DEFAULT NULL,
  `company_name` varchar(200) DEFAULT NULL,
  `search_count` int(11) DEFAULT '0' COMMENT '被搜索的次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='记录用户对公司的搜索次数';

-- ----------------------------
-- Records of drm_search_record
-- ----------------------------

-- ----------------------------
-- Table structure for `pt_feedback`
-- ----------------------------
DROP TABLE IF EXISTS `pt_feedback`;
CREATE TABLE `pt_feedback` (
  `id` int(11) NOT NULL,
  `content` varchar(4000) DEFAULT NULL COMMENT '反馈内容',
  `user_id` int(11) DEFAULT NULL COMMENT '反馈者id',
  `user_name` varchar(100) DEFAULT NULL COMMENT '反馈者名称',
  `caller_name` varchar(100) DEFAULT NULL COMMENT '称呼（未登录者填写）',
  `contact_type` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `submit_time` datetime DEFAULT NULL COMMENT '提交时间',
  `version` int(11) DEFAULT '0' COMMENT '记录版本号，每次修改递增1',
  `disabled` int(1) DEFAULT '0' COMMENT '逻辑删除标志，1删除0可用',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改者ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='意见反馈';

-- ----------------------------
-- Records of pt_feedback
-- ----------------------------

-- ----------------------------
-- Table structure for `pt_permission`
-- ----------------------------
DROP TABLE IF EXISTS `pt_permission`;
CREATE TABLE `pt_permission` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `permission_code` varchar(50) DEFAULT NULL,
  `permission_name` varchar(50) DEFAULT NULL,
  `permission_sequence` bigint(20) DEFAULT NULL,
  `resource` varchar(500) DEFAULT NULL,
  `app_id` bigint(20) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `type` tinyint(1) DEFAULT NULL,
  `version` int(20) NOT NULL DEFAULT '0' COMMENT '记录版本号，每次修改递增1',
  `disabled` int(1) DEFAULT '0' COMMENT '逻辑删除标志，1删除0可用',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改者ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `FK_parent_permission` (`parent_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1000011 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pt_permission
-- ----------------------------
INSERT INTO `pt_permission` VALUES ('1000001', 'USER_SET', '设置', null, '/ptuserset', '1', null, null, '0', '0', null, null, null, null);
INSERT INTO `pt_permission` VALUES ('1000002', 'MY_HOME', '我的主页', null, '/myhome', '1', null, null, '0', '0', null, null, null, null);
INSERT INTO `pt_permission` VALUES ('1000008', 'USER_MENU', '用户菜单', null, '/userSample/list', '1', null, null, '0', '0', null, null, null, null);
INSERT INTO `pt_permission` VALUES ('1000009', 'USER_ADD', '用户新增', null, '/userSample/toAdd', '1', '1000008', null, '0', '0', null, null, null, null);
INSERT INTO `pt_permission` VALUES ('1000010', 'MY_PFOFILE', '我的资料', null, '/profile', '1', null, null, '0', '0', null, null, null, null);

-- ----------------------------
-- Table structure for `pt_role`
-- ----------------------------
DROP TABLE IF EXISTS `pt_role`;
CREATE TABLE `pt_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL,
  `role_code` varchar(100) DEFAULT NULL,
  `version` int(11) DEFAULT '0' COMMENT '记录版本号，每次修改递增1',
  `disabled` int(1) DEFAULT '0' COMMENT '逻辑删除标志，1删除0可用',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改者ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pt_role
-- ----------------------------
INSERT INTO `pt_role` VALUES ('1', '管理员', 'admin', '0', '0', null, null, null, null);
INSERT INTO `pt_role` VALUES ('2', '访客', 'guest', '0', '0', null, null, null, null);

-- ----------------------------
-- Table structure for `pt_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `pt_role_permission`;
CREATE TABLE `pt_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_permission_role_permission` (`permission_id`) USING BTREE,
  KEY `FK_role_permission_role` (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pt_role_permission
-- ----------------------------
INSERT INTO `pt_role_permission` VALUES ('1', '1', '1000001');
INSERT INTO `pt_role_permission` VALUES ('2', '1', '1000009');
INSERT INTO `pt_role_permission` VALUES ('3', '2', '1000008');
INSERT INTO `pt_role_permission` VALUES ('4', '1', '1000002');

-- ----------------------------
-- Table structure for `pt_role_user`
-- ----------------------------
DROP TABLE IF EXISTS `pt_role_user`;
CREATE TABLE `pt_role_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of pt_role_user
-- ----------------------------
INSERT INTO `pt_role_user` VALUES ('1', '1', '1');
INSERT INTO `pt_role_user` VALUES ('2', '2', '2');

-- ----------------------------
-- Table structure for `pt_user`
-- ----------------------------
DROP TABLE IF EXISTS `pt_user`;
CREATE TABLE `pt_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `login_id` varchar(50) DEFAULT NULL COMMENT '登录名（手机号）',
  `pwd` varchar(50) DEFAULT NULL COMMENT '登录密码',
  `nickname` varchar(100) DEFAULT NULL COMMENT '昵称',
  `lastname` varchar(10) DEFAULT NULL COMMENT '姓',
  `realname` varchar(100) DEFAULT NULL COMMENT '真实姓名',
  `sex` int(11) DEFAULT NULL COMMENT '性别1男2女',
  `email` varchar(100) DEFAULT NULL COMMENT 'EMAIL',
  `province` varchar(10) DEFAULT NULL COMMENT '省',
  `city` varchar(20) DEFAULT NULL COMMENT '市',
  `county` varchar(30) DEFAULT NULL COMMENT '县区',
  `signature` varchar(500) DEFAULT NULL COMMENT '个性签名',
  `idcard` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `idcardfront` varchar(500) DEFAULT NULL COMMENT '身份证正面',
  `idcardback` varchar(500) DEFAULT NULL COMMENT '身份证反面',
  `percent` int(11) DEFAULT NULL COMMENT '资料完整度百分比',
  `workyears` int(11) DEFAULT NULL COMMENT '工作年限0应届毕业生，1一年以下，2：1-3年，3:3-5年，4:5-7年，5:7-10年，6:10年以上',
  `isoffline` int(11) DEFAULT NULL COMMENT '是否提供线下服务0不提供，1提供',
  `offlineprice` decimal(18,6) DEFAULT NULL COMMENT '线下服务价格每次',
  `qq` varchar(20) DEFAULT NULL COMMENT 'QQ号码',
  `weixin` varchar(100) DEFAULT NULL COMMENT '微信',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `cur_company_id` int(11) DEFAULT NULL COMMENT '当前公司ID',
  `cur_company_name` varchar(200) DEFAULT NULL COMMENT '当前公司名称',
  `cur_dept_name` varchar(200) DEFAULT NULL COMMENT '当前部门名称',
  `money_count` varchar(500) DEFAULT NULL COMMENT '收款账号',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  `disabled` int(11) DEFAULT '0' COMMENT '逻辑删除标志，1删除0可用',
  `create_userid` int(11) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_userid` int(11) DEFAULT NULL COMMENT '修改者id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pt_user
-- ----------------------------
INSERT INTO `pt_user` VALUES ('1', 'drm', '1', 'drm用户', 't111', 'sdf1111', '1', '306635282@qq.com', '', '', '', '', '', '', '', null, null, null, '0.000000', '3411', '', '', '44', '测试公司1', '', '3411', '0', '0', null, null, null, null);
INSERT INTO `pt_user` VALUES ('2', '130', '1', '130途牛用户', null, null, null, 'cyx_shzu@163.com', null, null, null, null, null, null, null, null, null, null, null, null, null, '130', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `pt_user` VALUES ('3', '131', '1', '131途牛用户', null, null, null, '1371748521@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, '131', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `pt_user` VALUES ('4', '132', '1', '132途牛用户', '吴', '', '1', '111@163.com', null, null, null, null, null, null, null, null, null, null, null, '', null, '132', '45', '水电费111', '', '', null, null, null, null, null, null);
INSERT INTO `pt_user` VALUES ('5', '133', '1', '133途牛苏宁用户', null, null, null, '306635282@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, '133', null, null, null, null, null, '0', null, '2015-09-02 11:16:51', null, null);
INSERT INTO `pt_user` VALUES ('9', '1', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, '0', null, '2015-09-02 11:19:31', null, null);
INSERT INTO `pt_user` VALUES ('10', '3', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, null, null, null, '0', null, '2015-09-02 11:20:46', null, null);
INSERT INTO `pt_user` VALUES ('11', '188', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '188', null, null, null, null, null, '0', null, '2015-09-02 13:54:09', null, null);
INSERT INTO `pt_user` VALUES ('12', '11', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '11', null, null, null, null, null, '0', null, '2015-09-02 13:55:51', null, null);

-- ----------------------------
-- Table structure for `pt_visit_log`
-- ----------------------------
DROP TABLE IF EXISTS `pt_visit_log`;
CREATE TABLE `pt_visit_log` (
  `id` int(11) NOT NULL,
  `visit_ip` varchar(30) DEFAULT NULL COMMENT '访问IP',
  `visit_time` datetime DEFAULT NULL COMMENT '访问时间',
  `visit_url` varchar(1000) DEFAULT NULL COMMENT '访问的地址',
  `visit_userid` int(11) DEFAULT NULL COMMENT '访问者id',
  `visit_username` varchar(100) DEFAULT NULL COMMENT '访问者用户名',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='url访问日志';

-- ----------------------------
-- Records of pt_visit_log
-- ----------------------------
