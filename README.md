# 班级考勤管理系统 (Attendance System)

本项目为《Java EE 开发实践》课程第四周作业，旨在通过 Spring Boot 框架实现一个标准的**分层架构**考勤管理系统。

## 1. 个人基本信息
- **姓名**：陈啸麟
- **学号**：42411095
- **专业**：网络空间安全
- **开发周期**：第1周 - 第4周

## 2. 项目分层架构说明
本项目严格遵循企业级标准三层架构思想，实现了逻辑解耦与职责分离：

- **Controller (控制层)**：负责接收前端请求（路径、查询、JSON参数），调用 Service 层业务逻辑，并返回统一格式的 `Result` 结果。
- **Service (业务逻辑层)**：采用面向接口编程模式。负责核心业务校验（如学号非空校验）及逻辑处理。
- **Dao/Repository (数据访问层)**：负责与底层数据交互。目前采用内存模拟（List/Map）存储，预留了 JdbcTemplate 数据库操作接口。
- **Entity (实体类层)**：定义了 `Student` 和 `Attendance` 的标准 POJO 类，遵循 Java Bean 规范。
- **Common (公共层)**：提供了 `Result<T>` 统一响应工具类，包含 `code`、`msg`、`data` 三大核心字段。

## 3. 已实现功能及接口清单

### 3.1 系统基础接口
- `GET /hello` : 返回系统欢迎信息。
- `GET /about` : 返回格式化的开发者个人基本信息（JSON 格式）。

### 3.2 学生管理模块 (Student Module)
- `GET /student/info/{studentId}` : **路径参数**查询。根据学号获取学生详细资料。
- `POST /student/create` : **JSON 提交**。新增学生信息，Service 层包含“学号及姓名不能为空”的业务校验。
- `GET /student/courses` : 获取当前学生可选的课程列表。

### 3.3 考勤管理模块 (Attendance Module)
- `POST /attendance/update` : **JSON 提交**。接收考勤对象，由 `AttendanceService` 处理更新逻辑，校验数据完整性后存入模拟库。
- `POST /student/attendance` : 学生简易打卡接口。

## 4. 技术栈
- **核心框架**：Spring Boot 3.x
- **项目管理**：Maven
- **版本控制**：Git
- **接口测试**：Postman / Apifox