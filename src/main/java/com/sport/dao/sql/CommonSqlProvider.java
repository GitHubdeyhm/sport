package com.sport.dao.sql;

import com.sport.common.MessageHelper;
import com.sport.common.annotation.Ignore;
import com.sport.common.annotation.Table;
import com.sport.entity.uums.MenuEntity;
import com.sport.util.StringUtil;

import java.lang.reflect.Field;

/**
 * 基本sql提供者
 * @author huangxiaolin
 * @date 2017-09-19 下午3:25
 */
public class CommonSqlProvider {

    /**主键的where条件，实体类的主键为id*/
    private static final String WHERE_ID = "id=#{id}";
    /**
     * 拼接实体类的insert语句
     * @date 2017-09-19 22:14
     */
    public String insert(final Object entity) {
//        Map<String, String> nameValueMap = SqlHelper.getFieldNameValueMap(obj);
//        return new SQL()
//                .INSERT_INTO(SqlHelper.getTableName(obj))
//                .INTO_COLUMNS(nameValueMap.get(SqlHelper.FIELD_NAME))
//                .INTO_VALUES(nameValueMap.get(SqlHelper.FIELD_VALUE))
//                .toString();
        Class<?> entityClass = entity.getClass();
        Field[] fields = entityClass.getDeclaredFields();
        StringBuilder fieldSql = new StringBuilder();
        StringBuilder valueSql = new StringBuilder();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                //没有被注解Ignore修饰的字段才映射到表的字段
                if (!field.isAnnotationPresent(Ignore.class) && (field.get(entity) != null)) {
                    fieldSql.append(",");
                    fieldSql.append(StringUtil.toUnderlineName(field.getName()));
                    //值
                    valueSql.append(",#{");
                    valueSql.append(field.getName());
                    valueSql.append("}");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //拼接sql语句
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ").append(getTableName(entityClass))
                .append("(")
                .append(fieldSql.substring(1, fieldSql.length()))
                .append(") VALUES (")
                .append(valueSql.substring(1, valueSql.length()))
                .append(")");
        return sql.toString();
    }

    /**
     * update语句
     * @date 2017-09-23 22:02
     */
    public String update(final Object entity) {
//        return new SQL()
//                .UPDATE(SqlHelper.getTableName(entity))
//                .SET(SqlHelper.getUpdateSet(entity))
//                .WHERE(WHERE_ID)
//                .toString();
        Class<?> entityClass = entity.getClass();
        Field[] fields = entityClass.getDeclaredFields();
        StringBuilder fieldSql = new StringBuilder();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                //没有被注解Ignore修饰的字段才映射到表的字段
                if (!field.isAnnotationPresent(Ignore.class) && (field.get(entity) != null)) {
                    fieldSql.append(",");
                    fieldSql.append(StringUtil.toUnderlineName(field.getName()));
                    fieldSql.append("=#{");
                    fieldSql.append(field.getName());
                    fieldSql.append("}");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //拼接sql语句
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE ").append(getTableName(entityClass))
                .append(" SET ")
                .append(fieldSql.substring(1, fieldSql.length()))
                .append(" WHERE ")
                .append(WHERE_ID);
        return sql.toString();
    }

    /**
     * 通过Table注解获取实体类对应的表名
     * @date 2017-09-19 22:06
     * obj 实体类对象
     */
    public static String getTableName(Class<?> clazz) {
        Table table = clazz.getDeclaredAnnotation(Table.class);
        if (table == null) {
            MessageHelper.throwMessage("实体类需要通过注解Table映射表名");
        }
        return table.value();
    }

    public static void main(String[] args) {
        CommonSqlProvider sqlProvider = new CommonSqlProvider();
        System.out.println(sqlProvider.insert(new MenuEntity(true)));
        System.out.println(sqlProvider.update(new MenuEntity(true)));
    }

}
