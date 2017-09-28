package com.sport.dao.sql;

import com.sport.common.annotation.Ignore;
import com.sport.common.annotation.Table;
import com.sport.util.StringUtil;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 编译sql语句的帮助类
 * @author huangxiaolin
 * @date 2017-09-19 下午3:25
 */
public class SqlHelper {

    public static final String FIELD_NAME = "name";
    public static final String FIELD_VALUE = "value";

    /**
     * 通过Table注解获取实体类对应的表名
     * @date 2017-09-19 22:06
     * obj 实体类对象
     */
    public static String getTableName(Object obj) {
        Class<?> clazz = obj.getClass();
        Table table = clazz.getDeclaredAnnotation(Table.class);
        return table.value();
    }

    public static String getFieldName(Object obj) {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        for (Field field : fields) {
            //没有被注解Ignore修饰的字段才映射到表的字段
            if (!field.isAnnotationPresent(Ignore.class)) {
                sb.append(field.getName());
                sb.append(",");
            }
        }
        return sb.substring(0, sb.length()-1);
    }

    public static String getFieldValue(Object obj) {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        try {
            for (Field field : fields) {
                //没有被注解Ignore修饰的字段才映射到表的字段
                if (!field.isAnnotationPresent(Ignore.class)) {
                    field.setAccessible(true);
                    sb.append(field.get(obj));
                    sb.append(",");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return sb.substring(0, sb.length()-1);
    }

    /**
     * 获取实体类字段的名称和mybatis设置值的语法
     * @date 2017-09-19 22:11
     * obj 实体类对象
     */
    public static Map<String, String> getFieldNameValueMap(Object obj) {
        Map<String, String> nameValueMap = new HashMap<>(2);
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder nameBulider = new StringBuilder();
        StringBuilder valueBulider = new StringBuilder();
        try {
            for (Field field : fields) {
                //没有被注解Ignore修饰的字段才映射到表的字段
                Ignore ignore = field.getDeclaredAnnotation(Ignore.class);
                field.setAccessible(true);
                if ((ignore == null) && (field.get(obj) != null)) {
                    nameBulider.append(StringUtil.toUnderlineName(field.getName()));
                    nameBulider.append(",");

                    valueBulider.append("#{");
                    valueBulider.append(field.getName());
                    valueBulider.append("},");
                }
            }
            nameValueMap.put(FIELD_NAME, nameBulider.substring(0, nameBulider.length()-1));
            nameValueMap.put(FIELD_VALUE, valueBulider.substring(0, valueBulider.length()-1));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return nameValueMap;
    }

    /**
     * 封装mybatis更新列表
     * @date 2017-09-19 22:32
     */
    public static String getUpdateSet(Object obj) {
        Map<String, String> nameValueMap = new HashMap<>(2);
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder setBulider = new StringBuilder();
        try {
            for (Field field : fields) {
                //没有被注解Ignore修饰的字段才映射到表的字段
                Ignore ignore = field.getDeclaredAnnotation(Ignore.class);
                field.setAccessible(true);
                if ((ignore == null) && (field.get(obj) != null)) {
                    setBulider.append(StringUtil.toUnderlineName(field.getName()));
                    setBulider.append("=");
                    setBulider.append("#{");
                    setBulider.append(field.getName());
                    setBulider.append("},");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return setBulider.substring(0, setBulider.length()-1);
    }



    public static void main(String[] args) throws Exception {

    }

}
