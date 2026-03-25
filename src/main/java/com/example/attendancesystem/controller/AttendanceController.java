package com.example.attendancesystem.controller;

import com.example.attendancesystem.entity.Attendance;
import com.example.attendancesystem.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/update")
    public Result<String> updateAttendance(@RequestBody Attendance attendance) {
        try {
            // 【修正点】：确保调用的是 updateAttendance，因为接口里叫这个名字
            String result = attendanceService.updateAttendance(attendance);
            return Result.success(result);
        } catch (RuntimeException e) {
            return Result.error(e.getMessage());
        }
    }
}