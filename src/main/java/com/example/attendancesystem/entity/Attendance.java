package com.example.attendancesystem.entity;

public class Attendance {
    private String studentId; // 学号
    private String courseId;  // 课程 ID
    private String status;    // 考勤状态（如：出勤、缺勤、迟到）
    private String date;
    // 日期

    public Attendance() {
    }

    public Attendance(String studentId, String courseId, String status, String date) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = status;
        this.date = date;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
