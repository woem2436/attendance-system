package com.example.attendancesystem.service;

import com.example.attendancesystem.entity.User;
import java.util.List;

public interface UserService {
    // 1. 新增用户
    String addUser(User user);

    // 2. 根据ID获取用户
    User getUserById(Long id);

    // 3. 获取所有教师列表 (对应本周核心任务)
    List<User> getAllTeachers();

    // 4. 更新用户
    String updateUser(User user);

    // 5. 删除用户
    String deleteUser(Long id);
}