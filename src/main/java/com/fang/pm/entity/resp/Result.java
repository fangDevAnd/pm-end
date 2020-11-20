package com.fang.pm.entity.resp;


public class Result {

    /**
     * 状态码 符合 restful 风格
     */
    private int code;

    /**
     * 消息
     */
    private String msg;

    /**
     * 数据的存储域
     */
    private Object data;

    /**
     * 操作的结果码
     */
    private int result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Result(int code, String msg, Object data, int result) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.result = result;
    }
}
