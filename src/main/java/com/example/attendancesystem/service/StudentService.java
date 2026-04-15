package com.example.attendancesystem.service;

import com.example.attendancesystem.entity.Student;
import java.util.List;

public interface StudentService {
    String createStudent(Student student);
    Student getStudentById(Long studentId); // 统一为 Long
    List<Student> getStudentsByClass(String className); // 对应任务二要求
}