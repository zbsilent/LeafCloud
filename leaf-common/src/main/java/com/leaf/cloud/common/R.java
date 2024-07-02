package com.leaf.cloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 通用响应类，用于封装API的响应数据。
 *
 * @author zbsilent
 * @version 1.0
 * @date 2024/7/2
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class R<T> {

    private int code; // 状态码
    private String msg; // 消息提示
    private T data; // 返回的数据
    private Long timeStamp; // 时间戳

    // 默认构造函数，初始化时间戳
    public R() {
        this.timeStamp = System.currentTimeMillis();
    }

    // 构造一个成功的响应，包含数据
    public R(T data) {
        this(200, "success", data);
    }

    // 构造一个指定状态码、消息和数据的响应
    public R(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.timeStamp = System.currentTimeMillis();
    }

    // 静态方法创建成功的响应，包含数据
    public static <T> R<T> success(T data) {
        return new R<>(200, "success", data);
    }

    // 静态方法创建成功的空响应
    public static <T> R<T> success() {
        return new R<>(200, "success", null);
    }

    // 静态方法创建错误的响应，包含数据
    public static <T> R<T> error(T data) {
        return new R<>(500, "error", data);
    }

    // 静态方法创建错误的空响应
    public static <T> R<T> error() {
        return new R<>(500, "error", null);
    }

    // 静态方法创建指定消息的错误响应
    public static <T> R<T> error(String msg) {
        return new R<>(500, msg, null);
    }

    // 静态方法创建指定状态码和消息的错误响应
    public static <T> R<T> error(int code, String msg) {
        return new R<>(code, msg, null);
    }
}