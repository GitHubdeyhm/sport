package com.sport.dao.manage;

import com.sport.dao.sql.CommonSqlProvider;
import com.sport.entity.manage.BaseDictEntity;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
 * @author huangxl
 * @date 2017-10-05 11:41
 */
@Mapper
public interface BaseDictDao {

    @InsertProvider(type = CommonSqlProvider.class, method = "insert")
    void save(BaseDictEntity dict);

    @UpdateProvider(type = CommonSqlProvider.class, method = "update")
    void update(BaseDictEntity dict);

    List<BaseDictEntity> findByKey(String key);
    /**
     * 通过父ID查询
     * @date 2017-10-05 23:53
     */
    List<BaseDictEntity> findByParentId(@Param("parentId") Integer parentId);
}
