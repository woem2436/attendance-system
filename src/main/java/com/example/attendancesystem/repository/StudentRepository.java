package com.example.attendancesystem.repository;

import com.example.attendancesystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // 1. 任务二核心要求：根据班级名称查询学生列表
    // 对应 SQL: SELECT * FROM student WHERE class_name = ?
    List<Student> findByClassName(String className);

    // 2. 扩展功能：根据学生姓名进行模糊查询
    // 对应 SQL: SELECT * FROM student WHERE student_name LIKE %name%
    List<Student> findByStudentNameContaining(String name);
}