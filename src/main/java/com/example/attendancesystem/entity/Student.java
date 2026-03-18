package com.example.attendancesystem.entity;

public class Student {
    private String studentId;   // 改为小驼峰 studentId
    private String studentName;
    private String className;
    private String age;

    public Student() {}

    public Student(String studentId, String studentName, String className, String age) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.className = className;
        this.age = age;
    }

    // Getter 和 Setter
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }
}