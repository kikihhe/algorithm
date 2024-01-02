package com.xiaohe.demo.util;

import lombok.Data;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-09-22 10:31
 */
@Data
public class Result <T>{
    private Integer code;

    private String message;

    private T data;

    public static <T> Result<T> success(String message, T object) {
        Result<T> result = new Result<>();
        result.data = object;
        result.code = 1;
        result.message = message;
        return result;
    }
    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<>();
        result.data = object;
        result.code = 1;
        result.message = "success";
        return result;
    }
    public static <T> Result<T> error(T object) {
        Result<T> result = new Result<>();
        result.data = object;
        result.code = 0;
        result.message = "error";
        return result;
    }
    public static <T> Result<T> error(String message, T object) {
        Result<T> result = new Result<>();
        result.data = object;
        result.code = 0;
        result.message = message;
        return result;
    }
}
