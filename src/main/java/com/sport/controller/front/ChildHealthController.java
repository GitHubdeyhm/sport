package com.sport.controller.front;

import com.sport.entity.uums.MenuEntity;
import com.sport.service.uums.MenuService;
import com.sport.util.CodeUtil;
import com.sport.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/health")
    public ModelAndView health(@RequestParam("mc") String menuCode) {
        return getNav(menuCode, "front/child-health");
    }


    private ModelAndView getNav(String menuCode, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("code", menuCode);
        mav.addObject("menuList", menuService.findForNav(menuCode));
        MenuEntity menu = new MenuEntity(true);
        if (!StringUtil.isBlank(menuCode)) {
            int level2 = CodeUtil.CODE_LEVEL_LENGTH * 2;//二级编码长度
            if (menuCode.length() >= level2) {
                menu.setMenuCode(menuCode.substring(0,level2)+"%");
            }
        }
        mav.addObject("childMenuList", menuService.find(menu));
        return mav;
    }
}
