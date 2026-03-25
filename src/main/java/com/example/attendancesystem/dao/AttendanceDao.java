package com.example.attendancesystem.dao;

import com.example.attendancesystem.entity.Attendance;
import org.springframework.stereotype.Repository;

@Repository
public class AttendanceDao {
    // 模拟数据库操作
    public void saveLog(String log) {
        System.out.println("【DAO日志】" + log);
    }

    public void saveRecord(Attendance attendance) {
        System.out.println("【DAO日志】存入考勤表：" + attendance.getStudentId());
    }
}