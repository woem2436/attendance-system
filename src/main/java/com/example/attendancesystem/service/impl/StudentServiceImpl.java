package com.example.attendancesystem.service.impl;

import com.example.attendancesystem.entity.Student;
import com.example.attendancesystem.service.StudentService;
import com.example.attendancesystem.dao.StudentDao; // 下一步创建
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao; // 注入Dao层

    @Override
    public String createStudent(Student student) {
        // 任务一要求的业务校验：学号不能为空
        if (student.getStudentId() == null || student.getStudentId().isEmpty()) {
            throw new RuntimeException("学号不能为空！");
        }
        if (student.getStudentName() == null || student.getStudentName().isEmpty()) {
            throw new RuntimeException("姓名不能为空！");
        }

        // 调用 Dao 层保存
        studentDao.insert(student);
        return "学生 " + student.getStudentName() + " 创建成功";
    }

    @Override
    public Student getStudentById(String studentId) {
        // 调用 Dao 层查询
        return studentDao.findById(studentId);
    }
}