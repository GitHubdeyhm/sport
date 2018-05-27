package com.sport.common.exception;

import com.sport.common.Message;

/**
 * 系统服务异常-自定义异常
 * @author huangxl
 * @date 2017-09-18 22:31
 */
public class ServiceException extends RuntimeException {

    private int code;

    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
    }

    public static void throwMessage(int code, String message) {
        throw new ServiceException(code, message);
    }

    public static void throwMessage(String key) {
        throw new ServiceException(-100, Message.getMessage(key));
    }

    /**
     * 抛出信息，响应页面信息
     * @date 2018-05-26 22:46
     */
    public static void throwMessage(Message message) {
        throw new ServiceException(message.getCode(), Message.getMessage(message.getKey()));
    }

    public int getCode() {
        return code;
    }
}
