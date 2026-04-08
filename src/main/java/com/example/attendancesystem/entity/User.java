package com.example.attendancesystem.entity;

/**
 * 用户实体类 (对应数据库 user 表)
 */
public class User {
    private Long id;            // 主键ID
    private String username;    // 用户名
    private String password;    // 密码
    private String realName;    // 真实姓名 (对应数据库 real_name)
    private String role;        // 角色: TEACHER/ADMIN

    // 1. 无参构造方法 (JdbcTemplate 必须要求有这个)
    public User() {
    }

    // 2. 全参构造方法 (方便我们以后快速创建对象)
    public User(Long id, String username, String password, String realName, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.role = role;
    }

    // 3. Getter 和 Setter 方法 (必须齐全，否则数据导不进对象)
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

    // 可选：toString 方法，方便你在控制台打印看数据
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}