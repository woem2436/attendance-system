package com.example.attendancesystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "student_id")
    private Long studentId; // 统一为 Long

    @Column(name = "student_name", nullable = false, length = 50)
    private String studentName;

    @Column(name = "class_name", length = 50)
    private String className;

    @Column(length = 10)
    private String age;

    // 1. 无参构造
    public Student() {
    }

    // 2. 全参构造
    public Student(Long studentId, String studentName, String className, String age) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.className = className;
        this.age = age;
    }

    // 3. Getter 和 Setter
    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }
}