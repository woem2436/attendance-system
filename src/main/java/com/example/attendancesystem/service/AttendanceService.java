package com.example.attendancesystem.service;

import com.example.attendancesystem.entity.Attendance;

public interface AttendanceService {
    // 任务：学生打卡（只需学号）
    String punchCard(String studentId);

    // 任务：更新详细考勤记录（JSON对象）
    String updateAttendance(Attendance attendance);
}