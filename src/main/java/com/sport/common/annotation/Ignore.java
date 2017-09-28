package com.sport.common.annotation;

import java.lang.annotation.*;

/**
 * 标注实体类不需要与表列名映射的字段
 * @author huangxl
 * @date 2017-09-19 21:58
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Ignore {
}
