package com.fang.pm.sub.base.base;

import java.io.Serializable;

/**
 * @author fang
 */
public class Result implements Serializable {
    private Object data;
    private int code;
    private String msg;


    public static final int CODE_SUCCESS = 200;

    //客户端错误
    //参数错误
    public static final int CODE_PARAM_ERROR = 402;
    //未授权
    public static final int CODE_NOT_AUTH = 401;

    //服务端错误
    public static final int CODE_SERVER_ERROR = 500;


    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
