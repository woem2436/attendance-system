package com.example.attendancesystem.repository;

import com.example.attendancesystem.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

    // 1. 课后作业核心要求：根据学号（Long类型）查询该生的所有考勤记录
    // 对应 SQL: SELECT * FROM attendance WHERE student_id = ?
    List<Attendance> findByStudentId(Long studentId);

    // 2. 进阶查询：根据课程ID和考勤状态查询
    // 对应 SQL: SELECT * FROM attendance WHERE course_id = ? AND status = ?
    List<Attendance> findByCourseIdAndStatus(String courseId, String status);
}