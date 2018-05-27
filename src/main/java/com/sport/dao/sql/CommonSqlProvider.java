package com.sport.dao.sql;

import com.sport.common.annotation.Ignore;
import com.sport.common.annotation.SelectIgnore;
import com.sport.common.annotation.Table;
import com.sport.common.exception.ServiceException;
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
                .append(fieldSql.substring(1))
                .append(") VALUES (")
                .append(valueSql.substring(1))
                .append(")");
        return sql.toString();
    }
    /**
     * update语句
     * @date 2017-09-23 22:02
     */
    public String update(final Object entity) {
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
                .append(fieldSql.substring(1))
                .append(" WHERE ")
                .append(WHERE_ID);
        return sql.toString();
    }

    /**
     * 拼接sql语句
     * @date 2017-12-08 21:44
     */
    public String findById(int id, Class<?> entityClass) {
        StringBuilder sql = new StringBuilder("SELECT * FROM ");
        sql.append(getTableName(entityClass));
        sql.append(WHERE_ID);
        return sql.toString();
    }

    /**
     * 查询语句
     * @date 2017-09-23 22:02
     */
    public String find(final Object entity) {
        Class<?> entityClass = entity.getClass();
        Field[] fields = entityClass.getDeclaredFields();
        StringBuilder fieldSql = new StringBuilder();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(SelectIgnore.class)) {
                    continue;
                }
                boolean isAppend = false;
                if (field.getType() == String.class) {
                    if (!StringUtil.isNullOrEmpty((String)field.get(entity))) {
                        isAppend = true;
                    }
                } else {
                    if ((field.get(entity) != null)) {
                        isAppend = true;
                    }
                }
                //添加查询条件
                if (isAppend) {
                    fieldSql.append(" AND ");
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
        sql.append("SELECT * FROM ").append(getTableName(entityClass))
                .append(" WHERE ")
                .append(fieldSql.substring(4));
        return sql.toString();
    }

    /**
     * 通过Table注解获取实体类对应的表名
     * @date 2017-09-19 22:06
     * obj 实体类对象
     */
    public static String getTableName(Class<?> entityClass) {
        Table table = entityClass.getDeclaredAnnotation(Table.class);
        if (table == null) {
            ServiceException.throwMessage("实体类需要通过注解Table映射表名");
        }
        String tableName = table.value();
        //默认数据库表的名称为类的名称下划线命名
        if (StringUtil.isNullOrEmpty(tableName)) {
            return StringUtil.toUnderlineName(entityClass.getSimpleName());
        }
        return table.value();
    }

    public static void main(String[] args) {
        CommonSqlProvider sqlProvider = new CommonSqlProvider();
        MenuEntity menu = new MenuEntity(true);
        menu.setMenuCode("001");
        menu.setMenuOrder(1);
        menu.setMenuName("");
        System.out.println(sqlProvider.insert(menu));
        System.out.println(sqlProvider.update(menu));
        System.out.println(sqlProvider.find(menu));
    }
}
