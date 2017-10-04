package com.sport.dao;

import com.sport.dao.sql.CommonSqlProvider;
import com.sport.entity.MenuEntity;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * 菜单
 * @author huangxl
 * @date 2017-09-24 21:32
 */
@Mapper
public interface MenuDao {

    @InsertProvider(type = CommonSqlProvider.class, method = "insert")
    void save(MenuEntity menu);

    @UpdateProvider(type = CommonSqlProvider.class, method = "update")
    void update(MenuEntity menu);

}
