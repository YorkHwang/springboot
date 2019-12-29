package com.york.common;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Json响应对象类
 * @author YorkHwang
 * @since 2017-06-21
 */
public class ResponseJson<T>{

    //成功
    public static final int SC_SUCCESS = 200;
    //服务端异常
    public static final int SC_SERVER_ERROR = 500;
    //客户端异常
    public static final int SC_CLIENT_ERROR = 400;

    public static final String MSG_SUCCESS = "success";
    public static final String MSG_SERVER_ERROR = "服务端异常,请联系管理员";

    private int code = SC_SUCCESS;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String msg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data = null;

    public ResponseJson() {
    }

    public int getCode() {
        return code;
    }

    public ResponseJson<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseJson<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }


    public ResponseJson<T> setData(T data) {
        this.data = data;
        return this;
    }

    public boolean succeed(){
        return this.code == SC_SUCCESS;
    }


    public static <T> ResponseJson success(T data) {
        return success(data, MSG_SUCCESS);
    }

    public static <T> ResponseJson success(T data, String message) {
        return new ResponseJson().setCode(SC_SUCCESS).setData(data).setMsg(message);
    }

    public static <T> ResponseJson serverError(String message) {
        return new ResponseJson().setCode(SC_SERVER_ERROR).setMsg(message);
    }


    public static <T> ResponseJson serverError() {
        return new ResponseJson().setCode(SC_SERVER_ERROR).setMsg(MSG_SERVER_ERROR);
    }

    public static <T> ResponseJson parameterError(String message) {
        return new ResponseJson().setCode(SC_CLIENT_ERROR).setMsg(message);
    }

}
