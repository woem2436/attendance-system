package com.example.attendancesystem.controller;

import com.example.attendancesystem.entity.Student;
import com.example.attendancesystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // --- 任务一：查询学生信息 (GET) ---
    @GetMapping("/info/{studentId}")
    public Result<Student> getStudentInfo(@PathVariable String studentId) {
        return Result.success(studentService.getStudentById(studentId));
    }

    // --- 【补全这里】：任务一：新增学生 (POST) ---
    // 对应你的 Postman 测试地址 http://localhost:8080/student/create
    @PostMapping("/create")
    public Result<String> createStudent(@RequestBody Student student) {
        try {
            String msg = studentService.createStudent(student);
            return Result.success(msg);
        } catch (RuntimeException e) {
            return Result.error(e.getMessage());
        }
    }

    // --- 任务二：课程列表 ---
    @GetMapping("/courses")
    public Result<List<String>> getCourseList() {
        List<String> courses = new ArrayList<>();
        courses.add("语文");
        courses.add("数学");
        courses.add("英语");
        return Result.success(courses);
    }

    // 注意：建议删掉这里原本的 studentAttendance 和 updateAttendance
    // 因为它们应该在 AttendanceController 里处理，避免路径冲突和职责混乱
}