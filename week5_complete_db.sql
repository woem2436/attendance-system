/*
 Navicat Premium Dump SQL

 Source Server         : attendance_system
 Source Server Type    : MySQL
 Source Server Version : 80012 (8.0.12)
 Source Host           : localhost:3306
 Source Schema         : attendance_system

 Target Server Type    : MySQL
 Target Server Version : 80012 (8.0.12)
 File Encoding         : 65001

 Date: 01/04/2026 09:36:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attendance
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `course_id` bigint(20) NULL DEFAULT NULL,
  `student_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学号',
  `student_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学生姓名',
  `check_in_time` datetime NULL DEFAULT NULL COMMENT '签到时间',
  `classroom_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '教室名称',
  `seat_row` tinyint(4) NULL DEFAULT NULL COMMENT '座位行号',
  `seat_col` tinyint(4) NULL DEFAULT NULL COMMENT '座位列号',
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'NORMAL' COMMENT '状态: NORMAL正常/LATE迟到/EARLY早退/ABSENT缺勤',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_attendance_course`(`course_id` ASC) USING BTREE,
  CONSTRAINT `fk_attendance_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '考勤记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES (1, 1, '42411095', '陈啸麟', NULL, '实验楼302', 3, 5, 'NORMAL', '2026-04-01 09:23:35');
INSERT INTO `attendance` VALUES (2, 1, '2024001', '张三', NULL, '实验楼302', 3, 6, 'NORMAL', '2026-04-01 09:23:35');
INSERT INTO `attendance` VALUES (3, 1, '2024005', '王小明', NULL, '实验楼302', 1, 1, 'NORMAL', '2026-04-01 09:33:56');
INSERT INTO `attendance` VALUES (4, 1, '2024006', '赵小红', NULL, '实验楼302', 1, 2, 'LATE', '2026-04-01 09:33:56');
INSERT INTO `attendance` VALUES (5, 2, '42411095', '陈啸麟', NULL, '实验楼401', 2, 3, 'NORMAL', '2026-04-01 09:33:56');
INSERT INTO `attendance` VALUES (6, 3, '42411095', '陈啸麟', NULL, '教学楼202', 5, 5, 'ABSENT', '2026-04-01 09:33:56');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `course_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程名称',
  `class_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '班级名称',
  `teacher_id` bigint(20) NOT NULL COMMENT '教师ID',
  `classroom_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '教室名称',
  `rows` tinyint(4) NULL DEFAULT NULL COMMENT '教室行数',
  `cols` tinyint(4) NULL DEFAULT NULL COMMENT '教室列数',
  `exclude_seats` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '不可坐位置坐标',
  `weekday` tinyint(4) NULL DEFAULT NULL COMMENT '星期几(1-7)',
  `start_week` int(11) NULL DEFAULT NULL COMMENT '开始周次',
  `end_week` int(11) NULL DEFAULT NULL COMMENT '结束周次',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_course_teacher`(`teacher_id` ASC) USING BTREE,
  CONSTRAINT `fk_course_teacher` FOREIGN KEY (`teacher_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 'Java EE 开发实践', '网安2024级1班', 2, '实验楼302', 8, 8, NULL, 3, 1, 16, '2026-04-01 09:21:00');
INSERT INTO `course` VALUES (2, '计算机网络', '网安2024级', 3, '实验楼401', 6, 6, NULL, 1, 1, 16, '2026-04-01 09:33:16');
INSERT INTO `course` VALUES (3, '现代 密码学', '网安2024级', 4, '教学楼202', 10, 8, NULL, 4, 1, 18, '2026-04-01 09:33:16');

-- ----------------------------
-- Table structure for course_selection
-- ----------------------------
DROP TABLE IF EXISTS `course_selection`;
CREATE TABLE `course_selection`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `student_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学号',
  `student_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学生姓名',
  `gender` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `course_id` bigint(20) NULL DEFAULT NULL,
  `select_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '选课时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_selection_course`(`course_id` ASC) USING BTREE,
  CONSTRAINT `fk_selection_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '选课表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_selection
-- ----------------------------
INSERT INTO `course_selection` VALUES (1, '42411095', '陈啸麟', '男', 1, '2026-04-01 09:22:37');
INSERT INTO `course_selection` VALUES (2, '2024001', '张三', '男', 1, '2026-04-01 09:22:37');
INSERT INTO `course_selection` VALUES (3, '2024002', '李四', '女', 1, '2026-04-01 09:22:37');
INSERT INTO `course_selection` VALUES (4, '2024003', '王五', '男', 1, '2026-04-01 09:22:37');
INSERT INTO `course_selection` VALUES (5, '2024004', '赵六', '女', 1, '2026-04-01 09:22:37');
INSERT INTO `course_selection` VALUES (6, '42411095', '陈啸麟', '男', 2, '2026-04-01 09:33:35');
INSERT INTO `course_selection` VALUES (7, '42411095', '陈啸麟', '男', 3, '2026-04-01 09:33:35');
INSERT INTO `course_selection` VALUES (8, '2024005', '王小明', '男', 1, '2026-04-01 09:33:35');
INSERT INTO `course_selection` VALUES (9, '2024006', '赵小红', '女', 1, '2026-04-01 09:33:35');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `role` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'USER' COMMENT '角色: TEACHER/ADMIN',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456', '系统管理员', 'ADMIN', NULL, NULL, '2026-04-01 09:11:32');
INSERT INTO `user` VALUES (2, 'zhou_teacher', '123456', '周老师', 'TEACHER', NULL, NULL, '2026-04-01 09:11:33');
INSERT INTO `user` VALUES (3, 'teacher_wang', '123456', '王老师', 'TEACHER', '13800000001', 'wang@school.edu', '2026-04-01 09:32:41');
INSERT INTO `user` VALUES (4, 'teacher_li', '123456', '李老师', 'TEACHER', '13800000002', 'li@school.edu', '2026-04-01 09:32:41');
INSERT INTO `user` VALUES (5, 'teacher_zhao', '123456', '赵老师', 'TEACHER', '13800000003', 'zhao@school.edu', '2026-04-01 09:32:41');

SET FOREIGN_KEY_CHECKS = 1;
