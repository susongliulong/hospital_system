package com.sun.common;

import java.io.Serializable;

/**
 * 封装返回数据，返回状态码以及提示信息
 */
public class R implements Serializable {

    private Object result;
    private String code;
    private String message;

    public R(Object result, String code, String message) {
        this.result = result;
        this.code = code;
        this.message = message;
    }

    public static R success(Object result){
        return new R(result,"200","处理过程很成功");
    }

    public static R error(Object result,String message){

        return new R(result,"100",message);
    }

    public static R warning(Object result,String message){

        return new R(result, "300",message);
    }

    public static R success(Object o, String message) {
        return new R(o,"200",message);
    }

    public Object getResult() {
        return result;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
