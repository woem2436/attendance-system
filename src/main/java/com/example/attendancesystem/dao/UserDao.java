package com.example.attendancesystem.dao;

import com.example.attendancesystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 标记为持久层组件，交给 Spring 管理
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate; // 自动注入配置好的 JDBC 工具

    /**
     * 1. 插入新用户 (Create)
     * 对应 SQL: INSERT INTO user ...
     */
    public int insert(User user) {
        String sql = "INSERT INTO user (username, password, real_name, role) VALUES (?, ?, ?, ?)";
        // update 方法用于 增、删、改
        return jdbcTemplate.update(sql,
                user.getUsername(),
                user.getPassword(),
                user.getRealName(),
                user.getRole());
    }

    /**
     * 2. 根据 ID 查询单个用户 (Read)
     * 使用 BeanPropertyRowMapper 自动将下划线列名(real_name)映射到驼峰属性(realName)
     */
    public User findById(Long id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        // queryForObject 用于查询单个对象
        // 注意：如果查不到数据，会抛出 EmptyResultDataAccessException 异常
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
    }

    /**
     * 3. 根据用户名查询 (用于验证登录名是否存在)
     */
    public User findByUsername(String username) {
        String sql = "SELECT * FROM user WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username);
    }

    /**
     * 4. 查询所有教师 (Read List)
     * 对应任务二第 7 条要求：查询 role 为 TEACHER 的所有用户
     */
    public List<User> findAllTeachers() {
        String sql = "SELECT * FROM user WHERE role = 'TEACHER'";
        // query 方法用于查询列表
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    /**
     * 5. 更新用户信息 (Update)
     */
    public int update(User user) {
        String sql = "UPDATE user SET password = ?, real_name = ?, role = ? WHERE id = ?";
        return jdbcTemplate.update(sql,
                user.getPassword(),
                user.getRealName(),
                user.getRole(),
                user.getId());
    }

    /**
     * 6. 删除用户 (Delete)
     */
    public int deleteById(Long id) {
        String sql = "DELETE FROM user WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}