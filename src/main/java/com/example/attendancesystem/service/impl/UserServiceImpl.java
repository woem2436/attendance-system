package com.example.attendancesystem.service.impl;

import com.example.attendancesystem.dao.UserDao;
import com.example.attendancesystem.entity.User;
import com.example.attendancesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // 必须加，否则 Controller 找不到它
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao; // 注入上一步写的 UserDao

    @Override
    public String addUser(User user) {
        int rows = userDao.insert(user);
        return rows > 0 ? "用户添加成功" : "用户添加失败";
    }

    @Override
    public User getUserById(Long id) {
        // 这里可以加逻辑：如果找不到可以抛出友好异常
        try {
            return userDao.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("未找到 ID 为 " + id + " 的用户");
        }
    }

    @Override
    public List<User> getAllTeachers() {
        return userDao.findAllTeachers();
    }

    @Override
    public String updateUser(User user) {
        int rows = userDao.update(user);
        return rows > 0 ? "更新成功" : "更新失败";
    }

    @Override
    public String deleteUser(Long id) {
        int rows = userDao.deleteById(id);
        return rows > 0 ? "删除成功" : "删除失败";
    }
}