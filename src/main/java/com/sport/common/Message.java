package com.sport.common;

/**
 * 用户请求的响应信息封装
 * @author huangxl
 * @date 2017-09-17 23:27
 */
public enum Message {
    SUCCESS(CommonCode.SUCCESS_CODE, "success_default_msg"),
    ERROR(CommonCode.ERROR_CODE, "server_error"),

    SERVER_ERROR(500, "server_error"),
    SESSION_TIMEOUT(-1, "session_timeout"),

    //用户相关信息用编码10XXX开头
    LOGINNAME_EXIST(-10000, "loginname_exist"),

    end(0, "");

    private int code;
    private String key;

    private Message(int code, String key) {
        this.code = code;
        this.key = key;
    }

    public int getCode() {
        return code;
    }

    public String getKey() {
        return key;
    }
}
