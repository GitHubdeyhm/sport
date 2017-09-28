package com.sport.common.annotation;

import java.lang.annotation.*;

/**
 * 用于实体类映射表名
 * @author huangxl
 * @date 2017-09-19 21:58
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    String value();
}
