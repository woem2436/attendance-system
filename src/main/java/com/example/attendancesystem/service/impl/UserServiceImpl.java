package com.example.attendancesystem.service.impl;

import com.example.attendancesystem.entity.User;
import com.example.attendancesystem.repository.UserRepository;
import com.example.attendancesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addUser(User user) {
        userRepository.save(user); // JPA 的 save 包含新增逻辑
        return "用户添加成功";
    }

    @Override
    public User getUserById(Long id) {
        // JPA 的 findById 返回 Optional，使用 orElse(null) 兼容旧逻辑
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllTeachers() {
        return userRepository.findByRole("TEACHER");
    }

    @Override
    public String updateUser(User user) {
        userRepository.save(user); // save 方法有 ID 时执行 Update
        return "更新成功";
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "删除成功";
    }
}