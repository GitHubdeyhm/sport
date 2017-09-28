package com.sport.common.annotation;

import java.lang.annotation.*;

/**
 * @author huangxl
 * @date 2017-09-19 22:23
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Id {
}
