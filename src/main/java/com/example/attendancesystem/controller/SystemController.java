package com.example.attendancesystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SystemController {

    @GetMapping("/hello")
    public Result<String> hello() {
        return Result.success("欢迎来到班级考勤管理系统！");
    }

    @GetMapping("/about")
    public Result<Map<String, String>> about() {
        // 使用 Map 封装信息，返回的 JSON 会更漂亮
        Map<String, String> info = new HashMap<>();
        info.put("name", "陈啸麟");
        info.put("studentId", "42411095");
        info.put("major", "网络空间安全");

        return Result.success(info);
    }
}