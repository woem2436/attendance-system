package com.example.attendancesystem.service.impl;

import com.example.attendancesystem.entity.Attendance;
import com.example.attendancesystem.repository.AttendanceRepository;
import com.example.attendancesystem.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public String punchCard(Long studentId) {
        if (studentId == null) {
            throw new RuntimeException("打卡失败：学号不能为空！");
        }

        Attendance attendance = new Attendance();
        attendance.setStudentId(studentId);
        attendance.setStatus("NORMAL");
        attendance.setCreateTime(LocalDateTime.now());

        attendanceRepository.save(attendance);
        return "学号为 " + studentId + " 的学生打卡成功！";
    }

    @Override
    public String updateAttendance(Attendance attendance) {
        if (attendance.getStudentId() == null || attendance.getCourseId() == null) {
            throw new RuntimeException("更新失败：学号或课程ID缺失！");
        }
        attendanceRepository.save(attendance);
        return "考勤记录更新成功";
    }

    @Override
    public List<Attendance> getRecordsByStudent(Long studentId) {
        // 调用 Repository 中实现的条件查询
        return attendanceRepository.findByStudentId(studentId);
    }
}