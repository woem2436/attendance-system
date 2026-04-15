package com.example.attendancesystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(name = "real_name", length = 50)
    private String realName;

    @Column(length = 20)
    private String role;

    // 1. 无参构造（JPA必须）
    public User() {
    }

    // 2. 全参构造
    public User(Long id, String username, String password, String realName, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.role = role;
    }

    // 3. Getter 和 Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRealName() { return realName; }
    public void setRealName(String realName) { this.realName = realName; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}