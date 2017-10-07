package com.sport.controller.manage;

import com.sport.common.Constant;
import com.sport.entity.uums.MenuEntity;
import com.sport.service.uums.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 网站首页
 * @author huangxl
 * @date 2017-10-04 22:48
 */
@RequestMapping("/manage")
@Controller
public class ManageController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        request.setAttribute(Constant.HTML_TITLE_KEY, "系统管理");
        MenuEntity menu = new MenuEntity("manage", true);
        menu.setMenuCode("002%");
        request.setAttribute("menuList", menuService.find(menu));
        return "manage/index";
    }

}
