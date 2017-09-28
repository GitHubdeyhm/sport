package com.sport.common;

import com.sport.common.exception.ServiceException;
import com.sport.util.file.FileUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 提示信息
 * @author huangxl
 * @date 2017-09-23 22:15
 */
public class MessageHelper {

    //缓存响应信息的map对象
    private static final Map<String, String> msgCacheMap = new HashMap<>();
    //信息属性文件名称
    private static final String MESSAGE_FILE = "message-zh_CN.properties";

    /**
     * 提示信息
     * @date 2017-09-23 22:37
     */
    public static void info(String key) {
        throw new ServiceException(getMessage(key));
    }

    public static void info(Message msg) {
        throw new ServiceException(getMessage(msg.getKey()));
    }

    public static String getMessage(String key) {
        String msg = msgCacheMap.get(key);
        if (msg == null) {
            msg = FileUtil.getPropertiesValueByKey(MESSAGE_FILE, key);
            msgCacheMap.put(key, msg);
        }
        return msg;
    }

}
