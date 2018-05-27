package com.sport.common;

/**
 * 项目常量定义
 * @author huangxl
 * @date 2017-09-17 23:20
 */
public interface Constant {

    String CHARSET_UTF8 = "UTF-8";

    /**响应请求成功的代码*/
    int SUCCESS_CODE = 1;
    /**响应请求失败的默认代码*/
    int ERROR_CODE = 0;

    /**响应结果信息的键*/
    String MESSAGE_KEY = "msg";
    /**响应结果编码的键*/
    String CODE_KEY = "code";

    /**html头信息的key*/
    String HTML_TITLE_KEY = "html_title";

    /**网站访问数量的key*/
    String ACCESS_COUNT_KEY = "access_count";

    /**项目根路径*/
    String WEB_ROOT = "webRoot";

    String TREENODE_ROOT_ID = "-1";
    String TREENODE_ROOT_TEXT = "请选择";

    String MENU_CODE_FORMAT = "%03d";
}
