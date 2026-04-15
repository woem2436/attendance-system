package com.example.attendancesystem.service.impl;

import com.example.attendancesystem.entity.Student;
import com.example.attendancesystem.repository.StudentRepository;
import com.example.attendancesystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String createStudent(Student student) {
        if (student.getStudentId() == null) {
            throw new RuntimeException("学号不能为空！");
        }
        studentRepository.save(student);
        return "学生 " + student.getStudentName() + " 创建成功";
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public List<Student> getStudentsByClass(String className) {
        // 调用 Repository 中的自定义查询
        return studentRepository.findByClassName(className);
    }
}