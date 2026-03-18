package com.example.attendancesystem.controller;

import com.example.attendancesystem.controller.Result;
import org.springframework.web.bind.annotation.*;
import com.example.attendancesystem.entity.Student;
import com.example.attendancesystem.entity.Attendance;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // 内部类建议也遵循规范
    static class StudentIdRequest {
        private String studentId;
        public String getStudentId() { return studentId; }
        public void setStudentId(String studentId) { this.studentId = studentId; }
    }

    // 任务一：查询学生信息
    @GetMapping("/student/info/{studentId}")
    public Result<Student> getStudentInfo(@PathVariable String studentId) { // 方法名建议改小写开头
        Student student = new Student();
        student.setStudentName("CXL");
        // 【修正点】：这里必须是 setStudentId，对应 Student 类里的定义
        student.setStudentId(studentId);
        student.setClassName("网安2024级");
        student.setAge("19");
        return Result.success(student);
    }

    // 修正：使其符合“统一响应格式”的要求
    @PostMapping("/student/attendance")
    public Result<String> studentAttendance(@RequestBody StudentIdRequest request){
        String studentid = request.getStudentId();
        return Result.success("学号为" + studentid + "的学生打卡成功！");
    }

    // 修正：使其符合“统一响应格式”的要求
    @GetMapping("/student/courses")
    public Result<List<String>> getCourseList(){
        List<String> courses = new ArrayList<>();
        courses.add("语文");
        courses.add("数学");
        courses.add("英语");
        return Result.success(courses);
    }

    // 任务二：查询学生列表
    @GetMapping("/student/list")
    public Result<List<Student>> getStudentList(
            @RequestParam String name,
            @RequestParam(defaultValue = "1") Integer page){
        List<Student> studentList = new ArrayList<>();
        // 注意：构造方法的参数顺序要和 Student.java 一致
        studentList.add(new Student("2023001", "张三", "计算机科学与技术1班", "20"));
        studentList.add(new Student("2023002", "李四", "软件工程2班", "20"));
        studentList.add(new Student("2023003", "王五", "信息安全3班", "20"));

        return Result.success(studentList);
    }

    // 任务三：考勤更新
    @PostMapping("/attendance/update")
    public Result<String> updateAttendance(@RequestBody Attendance attendance) {
        // 模拟业务校验：如果学号为空，返回 400 错误
        if (attendance.getStudentId() == null || attendance.getStudentId().isEmpty()) {
            return Result.error(400, "非法参数：学号不能为空");
        }

        // 模拟业务逻辑：这里以后会写保存到数据库的代码
        System.out.println("正在保存考勤记录到数据库...");

        String message = "考勤记录更新成功：学号=" + attendance.getStudentId() +
                ", 课程=" + attendance.getCourseId() +
                ", 状态=" + attendance.getStatus();

        return Result.success(message);
    }
}