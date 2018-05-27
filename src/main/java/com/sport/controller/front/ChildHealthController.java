package com.sport.controller.front;

import com.sport.common.Constant;
import com.sport.entity.uums.MenuEntity;
import com.sport.service.uums.MenuService;
import com.sport.util.CodeUtil;
import com.sport.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 少儿亚健康
 * @author huangxl
 * @date 2017-10-30 21:57
 */
@RequestMapping("/child")
@Controller
public class ChildHealthController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/health/{menuCode}")
    public ModelAndView health(@PathVariable String menuCode, HttpServletRequest request) {
        request.setAttribute(Constant.HTML_TITLE_KEY, "少儿亚健康训练");
        return getNav(menuCode, "front/child-health");
    }

    private ModelAndView getNav(String menuCode, String viewName) {
        int level = menuCode.length() % 3;
        if (level == 1) {
            menuCode = "00" + menuCode;
        } else if (level == 2) {
            menuCode = "0" + menuCode;
        }
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("code", menuCode);
        mav.addObject("menuList", menuService.findForNav(menuCode));
        MenuEntity menu = new MenuEntity(true);
        if (!StringUtil.isNullOrEmpty(menuCode)) {
            int level2 = CodeUtil.CODE_LEVEL_LENGTH * 2;//二级编码长度
            if (menuCode.length() >= level2) {
                menu.setMenuCode(menuCode.substring(0,level2)+"%");
            }
        }
        mav.addObject("childMenuList", menuService.find(menu));
        return mav;
    }
}
