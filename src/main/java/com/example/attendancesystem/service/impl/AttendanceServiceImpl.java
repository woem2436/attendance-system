package com.example.attendancesystem.service.impl;

import com.example.attendancesystem.entity.Attendance;
import com.example.attendancesystem.service.AttendanceService;
import com.example.attendancesystem.dao.AttendanceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceDao attendanceDao;

    @Override
    public String punchCard(String studentId) {
        if (studentId == null || studentId.isEmpty()) {
            throw new RuntimeException("打卡失败：学号不能为空！");
        }
        // 模拟调用数据库
        attendanceDao.saveLog("学生 " + studentId + " 在线打卡成功");
        return "学号为 " + studentId + " 的学生打卡成功！";
    }

    @Override
    public String updateAttendance(Attendance attendance) {
        // 业务校验：第四周要求的重点
        if (attendance.getStudentId() == null || attendance.getCourseId() == null) {
            throw new RuntimeException("更新失败：学号或课程ID缺失！");
        }

        attendanceDao.saveRecord(attendance);
        return "考勤记录更新成功：学号=" + attendance.getStudentId() +
                ", 课程=" + attendance.getCourseId();
    }
}