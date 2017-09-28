package com.sport.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * spring工具类，可以通过此类实现得到spring容器管理的bean。
 * 在spirng中实现XXXAware接口的类会自动注入当前容器的引用，通过当前容器的引用可以获取spring管理的bean对象
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext context = null;

    public SpringUtil() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (context == null) {
            context = applicationContext;
        }
    }

    public static ApplicationContext getContext() {
        return  context;
    }

    public static Object getBean(String name) {
        return context.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return context.getBean(name, clazz);
    }
}
