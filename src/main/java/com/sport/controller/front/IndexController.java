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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/message")
    public String leaveMessage() {
        return "common/leave-message";
    }

    @GetMapping("/contact/us")
    public ModelAndView contactUs(@RequestParam("mc") String menuCode) {
        return getNav(menuCode, "front/contact-us");
    }

    @GetMapping("/download")
    public ModelAndView download(@RequestParam("mc") String menuCode) {
        return getNav(menuCode, "front/download");
    }

    @GetMapping("/about/us")
    public ModelAndView aboutUs(@RequestParam("mc") String menuCode) {
        return getNav(menuCode, "front/about-us");
    }

    @GetMapping("/about/organ")
    public ModelAndView aboutOrgan(@RequestParam("mc") String menuCode) {
        return getNav(menuCode, "front/about-organ");
    }

    @GetMapping("/regist/notice")
    public ModelAndView registNotice(@RequestParam("mc") String menuCode) {
        return getNav(menuCode, "front/regist-notice");
    }

    @GetMapping("/enroller/info")
    public ModelAndView enrollerInfo(@RequestParam("mc") String menuCode) {
        return getNav(menuCode, "front/enroller-info");
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

    @GetMapping("/error/{errorCode}")
    public String error(@PathVariable String errorCode) {
        return "error/error"+errorCode;
    }
}
