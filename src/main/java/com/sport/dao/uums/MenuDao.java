package com.sport.dao.uums;

import com.sport.dao.sql.CommonSqlProvider;
import com.sport.entity.uums.MenuEntity;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

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

    @Select("SELECT MAX(menu_code) FROM t_uums_menu WHERE menu_code LIKE #{parentCodeLike}")
    String findByCode(String parentCodeLike);

    List<MenuEntity> find(MenuEntity menu);
}
