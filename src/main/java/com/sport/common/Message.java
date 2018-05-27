package com.sport.common;

import com.sport.util.file.FileUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户请求的响应信息封装
 * @author huangxl
 * @date 2017-09-17 23:27
 */
public enum Message {

    SERVER_ERROR(500, "server_error"),
    SESSION_TIMEOUT(-1, "session_timeout"),

    //用户相关信息用编码10XXX开头
    LOGINNAME_EXIST(-10000, "loginname_exist"),

    SUCCESS(Constant.SUCCESS_CODE, "success_default_msg"),
    ERROR(Constant.ERROR_CODE, "server_error");

    private final int code;
    private final String key;

    //缓存响应信息的map对象
    private static final Map<String, String> msgCacheMap = new HashMap<>();
    //信息属性文件名称
    private static final String MESSAGE_FILE = "message-zh_CN";

    Message(int code, String key) {
        this.code = code;
        this.key = key;
    }

    public static String getMessage(String key) {
        String msg = msgCacheMap.get(key);
        if (msg == null) {
            msg = FileUtil.getPropertiesValueByKey(MESSAGE_FILE, key);
            msgCacheMap.put(key, msg);
        }
        return msg;
    }

    public int getCode() {
        return code;
    }

    public String getKey() {
        return key;
    }
}
