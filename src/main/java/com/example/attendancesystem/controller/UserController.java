package com.example.attendancesystem.controller;

import com.example.attendancesystem.entity.User;
import com.example.attendancesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user") // 统一前缀
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 1. 根据 ID 查询用户
     * 测试地址：GET http://localhost:8080/user/1
     */
    @GetMapping("/{id}")
    public Result<User> getUser(@PathVariable Long id) {
        try {
            User user = userService.getUserById(id);
            return Result.success(user);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 2. 查询所有教师
     * 测试地址：GET http://localhost:8080/user/teachers
     */
    @GetMapping("/teachers")
    public Result<List<User>> getTeachers() {
        List<User> teachers = userService.getAllTeachers();
        return Result.success(teachers);
    }

    /**
     * 3. 添加新用户
     * 测试地址：POST http://localhost:8080/user/add
     */
    @PostMapping("/add")
    public Result<String> addUser(@RequestBody User user) {
        String msg = userService.addUser(user);
        return Result.success(msg);
    }

    /**
     * 4. 删除用户
     * 测试地址：DELETE http://localhost:8080/user/delete/1
     */
    @DeleteMapping("/delete/{id}")
    public Result<String> deleteUser(@PathVariable Long id) {
        String msg = userService.deleteUser(id);
        return Result.success(msg);
    }
}