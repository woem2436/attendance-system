# 班级考勤管理系统 (Attendance System)

本项目为《Java EE 开发实践》课程系列作业，旨在通过 Spring Boot 框架实现一个标准的、基于 **MySQL 数据库** 驱动的**分层架构**考勤管理系统。

## 1. 个人基本信息
- **姓名**：陈啸麟
- **学号**：42411095
- **专业**：网络空间安全
- **开发周期**：第 1 周 - 第 6 周

## 2. 项目分层架构说明
本项目严格遵循企业级标准三层架构思想，实现了逻辑解耦与职责分离：

- **Controller (控制层)**：负责接收 HTTP 请求，调用 Service 层业务逻辑，并返回统一格式的 `Result<T>` 结果。
- **Service (业务逻辑层)**：采用面向接口编程模式。负责核心业务校验、事务管理及逻辑处理。
- **Dao/Repository (数据访问层)**：**[已升级]** 弃用早期的内存模拟方式，全面采用 **Spring JdbcTemplate** 实现对 MySQL 数据库的 CRUD 操作。
- **Entity (实体类层)**：定义了与数据库表结构一一对应的 POJO 类，包含 `User`、`Student` 和 `Attendance`。
- **Common (公共层)**：提供了统一响应工具类 `Result`，标准化了前端对接协议。

## 3. 数据库设计 (Database Design)
项目基于 **MySQL 8.0** 进行了规范化设计，遵循第三范式 (3NF)：
- **user 表**：存储管理员及教师信息。
- **course 表**：存储课程信息，通过教师 ID 与 user 表关联。
- **course_selection 表**：记录学生选课关系。
- **attendance 表**：记录详细考勤流水，通过外键约束确保数据一致性。
- **初始化脚本**：存放于项目根目录 `/sql` 文件夹下。

## 4. 已实现功能及接口清单

### 4.1 用户管理模块 (User Module) - [第六周新增]
- `GET /user/{id}` : 根据 ID 查询用户详情。
- `GET /user/teachers` : 获取系统中所有教师角色的列表。
- `POST /user/add` : 动态新增用户信息。
- `DELETE /user/delete/{id}` : 根据主键逻辑删除用户。

### 4.2 学生与考勤模块
- `GET /student/info/{studentId}` : 路径参数查询学生资料。
- `POST /student/create` : 新增学生信息（含业务非空校验）。
- `POST /attendance/update` : 提交/更新考勤记录。
- `GET /student/courses` : 获取可选课程列表。

### 4.3 系统基础接口
- `GET /hello` : 欢迎页面接口。
- `GET /about` : 返回个人基本信息 JSON 对象。

## 5. 技术栈 (Tech Stack)
- **核心框架**：Spring Boot 3.x
- **数据访问**：Spring JDBC (JdbcTemplate)
- **数据库**：MySQL 8.0.12 (小皮面板环境)
- **项目管理**：Maven
- **版本控制**：Git
- **接口测试**：Postman