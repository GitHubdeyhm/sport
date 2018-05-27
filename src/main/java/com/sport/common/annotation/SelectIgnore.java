package com.sport.common.annotation;

import java.lang.annotation.*;

/**
 * 标注实体类查询时不需要添加到查询条件的字段
 * @author huangxl
 * @date 2017-09-19 21:58
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SelectIgnore {
}
