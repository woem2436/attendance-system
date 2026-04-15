package com.example.attendancesystem.service;

import com.example.attendancesystem.entity.User;
import java.util.List;

public interface UserService {
    String addUser(User user);
    User getUserById(Long id);
    List<User> getAllTeachers();
    String updateUser(User user);
    String deleteUser(Long id);
}