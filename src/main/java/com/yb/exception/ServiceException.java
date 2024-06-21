package com.yb.exception;


import com.yb.enums.CommonExceptionEnum;

/**
 * 业务异常
 */
public class ServiceException extends RuntimeException {

    private int code;

    private String msg;

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

    public ServiceException(String msg) {
        this.code = CommonExceptionEnum.ERROR500.getCode();
        this.msg = msg;
    }

    public ServiceException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
