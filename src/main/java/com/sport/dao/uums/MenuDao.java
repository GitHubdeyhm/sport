package com.sport.dao.uums;

import com.sport.dao.sql.CommonSqlProvider;
import com.sport.entity.uums.MenuEntity;
import org.apache.ibatis.annotations.*;

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

    @Select("SELECT MAX(menu_order) from t_uums_menu WHERE menu_code LIKE #{parentCodeLike}")
    Integer genOrderNum(String parentCodeLike);

    List<MenuEntity> find(MenuEntity menu);

    @Select("select * from t_uums_menu where id = #{id}")
    MenuEntity findById(int id);

    /**
     * 根据编码查询菜单，用于导航
     * @date 2017-10-08 14:39
     */
    List<MenuEntity> findNavMenu(@Param("codes") List<String> codes);
}
