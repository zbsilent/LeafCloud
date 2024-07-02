package com.leaf.cloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zbsilent
 * @version 1.0
 * @description: TODO
 * @date 2024/7/2 下午11:03
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class R<T> {

    private int code;
    private String msg;
    private T data;
    private Long timeStamp;

    public R() {
        this.timeStamp = System.currentTimeMillis();
    }

    // 成功返回
    public R(T data) {
        this.data = data;
        this.timeStamp = System.currentTimeMillis();
        this.code = 200;
        this.msg = "success";
    }

    public static <T> R<T> success(T data) {
        return new R<T>().setCode(200).setMsg("success").setData(data);
    }

    public static <T> R<T> success() {
        return new R<T>().setCode(200).setMsg("success");
    }

    public static <T> R<T> error(T data) {
        return new R<T>().setCode(500).setMsg("error").setData(data);
    }

    public static <T> R<T> error() {
        return new R<T>().setCode(500).setMsg("error");
    }

    public static <T> R<T> error(String msg) {
        return new R<T>().setCode(500).setMsg(msg);
    }

    public static <T> R<T> error(Integer code, String msg) {
        return new R<T>().setCode(code).setMsg(msg);
    }


}
