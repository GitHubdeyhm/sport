package com.sport.service.uums;

import com.sport.common.MessageHelper;
import com.sport.dao.uums.MenuDao;
import com.sport.entity.uums.MenuEntity;
import com.sport.util.CodeUtil;
import com.sport.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
            String parentCode = null;
            menu.setMenuCode(CodeUtil.generateCode(parentCode, findByCode(parentCode)));
            menuDao.save(menu);
        } else {
            menuDao.update(menu);
        }
    }

    /**
     * 菜单查询
     * @date 2017-10-04 23:23
     */
    public List<MenuEntity> find(MenuEntity menu) {
        if (StringUtil.isBlank(menu.getMenuProjectCode())) {
            menu.setMenuProjectCode("front");
        }
        return menuDao.find(menu);
    }

    public String findByCode(String parentCode) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CodeUtil.CODE_LEVEL_LENGTH; i++) {
            sb.append("_");
        }
        if (StringUtil.isBlank(parentCode)) {
            return menuDao.findByCode(sb.toString());
        }
        return menuDao.findByCode(parentCode + sb.toString());
    }
}
