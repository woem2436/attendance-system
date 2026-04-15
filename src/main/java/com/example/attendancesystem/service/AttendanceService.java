package com.example.attendancesystem.service;

import com.example.attendancesystem.entity.Attendance;
import java.util.List;

public interface AttendanceService {
    String punchCard(Long studentId); // 统一为 Long
    String updateAttendance(Attendance attendance);
    // 【课后作业】：按学号查询考勤记录
    List<Attendance> getRecordsByStudent(Long studentId);
}