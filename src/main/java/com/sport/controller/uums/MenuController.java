package com.sport.controller.uums;

import com.sport.common.Constant;
import com.sport.common.ResponseResult;
import com.sport.entity.uums.MenuEntity;
import com.sport.service.uums.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author huangxl
 * @date 2017-09-24 21:12
 */
@RequestMapping("/manage/menu")
@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("page")
    public ModelAndView page() {
        ModelAndView mav = new ModelAndView("uums/menu");
        mav.addObject(Constant.HTML_TITLE_KEY, "菜单信息");
        mav.addObject("menuList", menuService.find(new MenuEntity("manage")));
        return mav;
    }

    @PostMapping("/save")
    @ResponseBody
    public ResponseResult<String> saveOrUpdate(MenuEntity menu) {
        menuService.saveOrUpdate(menu);
        return ResponseResult.successResult();
    }

    @ResponseBody
    @GetMapping("/test")
    public String test() {
        System.out.println("---进入了test()方法-----");

        return "response:";
    }
}

