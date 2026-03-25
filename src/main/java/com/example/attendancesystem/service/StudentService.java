package com.example.attendancesystem.service;

import com.example.attendancesystem.entity.Student;

public interface StudentService {
    // 新增学生
    String createStudent(Student student);
    // 根据ID获取学生
    Student getStudentById(String studentId);
}