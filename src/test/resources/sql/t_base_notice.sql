/*
 Navicat Premium Data Transfer

 Source Server         : 252:3309
 Source Server Type    : MySQL
 Source Server Version : 50540
 Source Host           : 192.168.1.252:3309
 Source Schema         : ehr_das

 Target Server Type    : MySQL
 Target Server Version : 50540
 File Encoding         : 65001

 Date: 17/05/2019 15:56:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_base_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_base_notice`;
CREATE TABLE `t_base_notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `type` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '01' COMMENT '类型（\'01\':文本）',
  `state` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '00' COMMENT '状态（\'00\':未发布\',01\':发布，\'02\':撤销）',
  `publish_time` timestamp NULL DEFAULT NULL COMMENT '发布时间',
  `create_user` int(11) NOT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` int(11) NULL DEFAULT NULL COMMENT '更新人',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `istop` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '02' COMMENT '是否置顶（\'01\':是，\'02\':否）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '通知公告表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_base_notice
-- ----------------------------
INSERT INTO `t_base_notice` VALUES (1, '中华预防医学会科学技术奖申报系统开始试运行！', '<p>1、中华预防医学会科学技术奖申报系统开始试运行！</p><p>2、中华预防医学会科学技术奖申报系统开始试运行！</p><p>3、中华预防医学会科学技术奖申报系统开始试运行！</p><p><img src=\"/CPMA-STR/files/upload/image/20190111/1547199656248014314.jpg\" title=\"1547199656248014314.jpg\" alt=\"1.jpg\" width=\"369\" height=\"210\"/></p>', '01', '01', '2018-09-27 15:54:16', 1, '2018-09-27 14:24:45', 1, '2019-01-11 17:44:37', '01');
INSERT INTO `t_base_notice` VALUES (2, '中华预防医学会科学技术奖申报系统开始试运行！', '<p style=\"line-height: 16px;\"><img src=\"/CPMA-STR/ueditor/dialogs/attachment/fileTypeImages/icon_xls.gif\"/><a style=\"font-size:12px; color:#0066cc;\" href=\"/CPMA-STR/files/upload/file/20190114/1547433220455019366.xls\" title=\"IE-KANOEDU-问题跟踪表（总表）.xls\">IE-KANOEDU-问题跟踪表（总表）.xls</a></p><p>中华预防医学会科学技术奖申报系统开始试运行！<br/></p>', '01', '01', '2018-09-27 15:54:16', 1, '2018-09-27 14:25:01', 1, '2019-01-14 10:33:46', '02');
INSERT INTO `t_base_notice` VALUES (4, '中华预防医学会科学技术奖申报系统', '<p>中华预防医学会科学技术奖申报系统正式开始上线运行。</p><p>中华预防医学会科学技术奖申报系统正式开始上线运行。</p><p>中华预防医学会科学技术奖申报系统正式开始上线运行。</p><p>中华预防医学会科学技术奖申报系统正式开始上线运行。</p>', '01', '01', '2018-09-28 14:55:07', 1, '2018-09-28 14:55:03', 1, '2019-01-11 17:07:33', '01');

SET FOREIGN_KEY_CHECKS = 1;
