package com.sport.service;

import com.sport.common.MessageHelper;
import com.sport.dao.MenuDao;
import com.sport.entity.MenuEntity;
import com.sport.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 菜单
 * @author huangxl
 * @date 2017-09-24 21:31
 */
@Service
@Transactional
public class MenuService {

    @Autowired
    private MenuDao menuDao;

    public void saveOrUpdate(MenuEntity menu) {
        if (StringUtil.isBlank(menu.getMenuName())) {
            MessageHelper.message("menu.name.empty");
        }
        if (menu.getId() == null) {
            menu.setMenuCode("001");
            menu.setMenuProjectCode("p001");
            menuDao.save(menu);
        } else {
            menuDao.update(menu);
        }
    }
}
