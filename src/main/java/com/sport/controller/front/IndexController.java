package com.sport.controller.front;

import com.sport.common.Constant;
import com.sport.entity.uums.MenuEntity;
import com.sport.service.uums.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/**
 * 网站首页
 * @author huangxl
 * @date 2017-10-04 22:48
 */
@Controller("index")
public class IndexController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        request.setAttribute(Constant.HTML_TITLE_KEY, "首页");
        MenuEntity menu = new MenuEntity("front", true);
        menu.setMenuCode("001%");
        request.setAttribute("menuList", menuService.find(menu));
        return "front/index";
    }

    @GetMapping("/error/{errorCode}")
    public String error(@PathVariable String errorCode) {
        return "error/error"+errorCode;
    }
}
