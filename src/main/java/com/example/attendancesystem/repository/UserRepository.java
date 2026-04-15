package com.example.attendancesystem.repository;

import com.example.attendancesystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // 1. 根据用户名查询（用于后续的登录功能）
    User findByUsername(String username);

    // 2. 根据角色查询（本周核心任务：获取所有教师列表）
    // 对应 SQL: SELECT * FROM user WHERE role = ?
    List<User> findByRole(String role);
}