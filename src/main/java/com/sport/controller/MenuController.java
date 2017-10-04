package com.sport.controller;

import com.sport.common.ResponseResult;
import com.sport.entity.MenuEntity;
import com.sport.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huangxl
 * @date 2017-09-24 21:12
 */
@RequestMapping("/menu")
@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("page")
    public String page() {
        return "uums/menu";
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

