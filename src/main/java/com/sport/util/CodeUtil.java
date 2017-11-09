package com.sport.util;

import com.sport.common.MessageHelper;

import java.util.Date;

/**
 * 生成编码工具类
 */
public class CodeUtil {

    /**编码的格式，不足补0*/
    private static final String CODE_FORMATE = "%03d";
    private static final int MAX_CODE = 999;
    /**编码每3位一级*/
    public static final int CODE_LEVEL_LENGTH = 3;

    /**
     * 根据最大子编码和父编码自动生成编码的方法
     * <p>生成规则：编码3位一级，编码的取值范围为：001--999</p>
     * <p>当编码超出范围时返回null，提示编码超出最大范围</p>
     */
    public static String generateCode(String parentCode, String maxChildCode) {
        String maxCode = "0";
        if (!StringUtil.isBlank(maxChildCode)) {
            maxCode = maxChildCode.substring(maxChildCode.length() - CODE_LEVEL_LENGTH);
        }
        int codeVal = Integer.parseInt(maxCode) + 1;
        //编码超出了最大范围，返回null
        if (codeVal > MAX_CODE) {
            MessageHelper.throwMessage("code.max.range");
        }
        if (StringUtil.isBlank(parentCode)) {
            parentCode = "";
        }
        return parentCode + String.format(CODE_FORMATE, codeVal);
    }

    /**
     * 常用于通过当前时间自动生成编码，需精确到毫秒，可以通过加一个前缀表明
     * @param preffix ：编码前缀
     * @return 编码
     */
    public static String getTimeCode(String preffix) {
        return preffix + DateUtil.formatMillisecond(new Date());
    }

}
