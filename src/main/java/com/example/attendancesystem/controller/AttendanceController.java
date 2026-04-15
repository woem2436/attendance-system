package com.example.attendancesystem.controller;
import com.example.attendancesystem.entity.Attendance;
import com.example.attendancesystem.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired private AttendanceService attendanceService;

    @PostMapping("/update")
    public Result<String> update(@RequestBody Attendance a) {
        return Result.success(attendanceService.updateAttendance(a));
    }

    @GetMapping("/record/{studentId}")
    public Result<List<Attendance>> getRecord(@PathVariable Long studentId) {
        return Result.success(attendanceService.getRecordsByStudent(studentId));
    }
}