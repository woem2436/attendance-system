package com.example.attendancesystem.dao;

import com.example.attendancesystem.entity.Student;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDao {

    // 暂时模拟一个内存列表当数据库
    private static List<Student> mockDatabase = new ArrayList<>();

    public void insert(Student student) {
        mockDatabase.add(student);
        System.out.println("【数据库模拟】成功插入数据：" + student.getStudentName());
    }

    public Student findById(String studentId) {
        // 模拟查询逻辑
        return new Student(studentId, "模拟学生", "网安2024级", "19");
    }
}