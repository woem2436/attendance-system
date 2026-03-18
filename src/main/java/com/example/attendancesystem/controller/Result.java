package com.example.attendancesystem.controller;

/**
 * 完善后的统一响应结果类
 */
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public Result() {}

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // --- 静态快捷方法 ---

    // 成功：带数据
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "操作成功", data);
    }

    // 成功：不带数据
    public static <T> Result<T> success() {
        return new Result<>(200, "操作成功", null);
    }

    // 失败：通用错误（500）
    public static <T> Result<T> error(String message) {
        return new Result<>(500, message, null);
    }

    // 失败：自定义错误码（用于课后作业要求的“更多响应状态”）
    public static <T> Result<T> error(Integer code, String message) {
        return new Result<>(code, message, null);
    }

    // --- Getter 和 Setter ---
    public Integer getCode() { return code; }
    public void setCode(Integer code) { this.code = code; }
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}