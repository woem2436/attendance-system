package com.example.attendancesystem.controller;
import com.example.attendancesystem.entity.Student;
import com.example.attendancesystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired private StudentService studentService;

    @GetMapping("/info/{id}")
    public Result<Student> getInfo(@PathVariable Long id) {
        return Result.success(studentService.getStudentById(id));
    }

    @GetMapping("/list/{className}")
    public Result<List<Student>> getByClass(@PathVariable String className) {
        return Result.success(studentService.getStudentsByClass(className));
    }

    @PostMapping("/create")
    public Result<String> create(@RequestBody Student s) {
        return Result.success(studentService.createStudent(s));
    }
}