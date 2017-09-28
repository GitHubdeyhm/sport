package com.sport.common.exception;

/**
 * 系统服务异常-自定义异常
 * @author huangxl
 * @date 2017-09-18 22:31
 */
public class ServiceException extends RuntimeException{

    private int code;

    public ServiceException () {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
    }

    public static void info(String message) {
        throw new ServiceException(message);
    }

    public int getCode() {
        return code;
    }
}
