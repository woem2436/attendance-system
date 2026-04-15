package com.example.attendancesystem.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "course_id", length = 20)
    private String courseId;

    @Column(name = "student_id")
    private Long studentId; // 修改为 Long，与 Student 类对齐

    @Column(name = "student_name", length = 50)
    private String studentName;

    @Column(length = 20)
    private String status;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    // 1. 无参构造
    public Attendance() {
    }

    // 2. 全参构造
    public Attendance(Integer id, String courseId, Long studentId, String studentName, String status, LocalDateTime createTime) {
        this.id = id;
        this.courseId = courseId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.status = status;
        this.createTime = createTime;
    }

    // 3. Getter 和 Setter
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }
}