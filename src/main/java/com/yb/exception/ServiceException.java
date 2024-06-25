package com.yb.exception;


import com.yb.enums.CommonExceptionEnum;
import lombok.Getter;

/**
 * 业务异常
 */
@Getter
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 4433467257027780978L;

    private final int code;

    private final String msg;


    public ServiceException(String msg) {
        this.code = CommonExceptionEnum.ERROR500.getCode();
        this.msg = msg;
    }

    public ServiceException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
