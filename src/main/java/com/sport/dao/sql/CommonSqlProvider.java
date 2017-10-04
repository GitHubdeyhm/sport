package com.sport.dao.sql;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * 通过sql提供者
 * @author huangxiaolin
 * @date 2017-09-19 下午3:25
 */
public class CommonSqlProvider {

    /**主键的where条件，实体类的主键为id*/
    private static final String WHERE_ID = "id=#{id}";

    /**
     * insert语句
     * @date 2017-09-19 22:14
     */
    public String insert(final Object obj) {
        Map<String, String> nameValueMap = SqlHelper.getFieldNameValueMap(obj);
        return new SQL()
                .INSERT_INTO(SqlHelper.getTableName(obj))
                .VALUES(nameValueMap.get(SqlHelper.FIELD_NAME), nameValueMap.get(SqlHelper.FIELD_VALUE))
                .toString();
    }

    /**
     * update语句
     * @date 2017-09-23 22:02
     */
    public String update(final Object obj) {
        return new SQL().UPDATE(SqlHelper.getTableName(obj))
                .SET(SqlHelper.getUpdateSet(obj))
                .WHERE(WHERE_ID)
                .toString();
    }
}
