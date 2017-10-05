package com.sport.dao.manage;

import com.sport.dao.sql.CommonSqlProvider;
import com.sport.entity.manage.AccessCountEntity;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 网站访问数量统计
 * @author huangxl
 * @date 2017-10-04 14:31
 */
@Mapper
public interface AccessCountDao {

    @InsertProvider(type = CommonSqlProvider.class, method = "insert")
    void save(AccessCountEntity ac);

    @Select("SELECT * FROM t_access_count ORDER BY count_date DESC LIMIT 1")
    AccessCountEntity findLateCount();


}
