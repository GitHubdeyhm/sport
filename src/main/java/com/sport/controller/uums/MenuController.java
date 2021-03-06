package com.sport.controller.uums;

import com.sport.common.Constant;
import com.sport.common.Message;
import com.sport.common.ResponseResult;
import com.sport.common.easyui.Datagrid;
import com.sport.common.easyui.TreeNode;
import com.sport.entity.uums.MenuEntity;
import com.sport.service.uums.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author huangxl
 * @date 2017-09-24 21:12
 */
@RequestMapping("/uums/menu")
@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("page")
    public ModelAndView page() {
        ModelAndView mav = new ModelAndView("uums/menu");
        mav.addObject(Constant.HTML_TITLE_KEY, "菜单管理");
        mav.addObject("menuList", menuService.find(new MenuEntity("manage", true)));
        return mav;
    }

    @PostMapping("/showList")
    @ResponseBody
    public Datagrid<MenuEntity> showList() {
        Datagrid<MenuEntity> dg = new Datagrid<>();
        dg.setRows(menuService.find(null));
        return dg;
    }

    @GetMapping("/input")
    public String input(){
        return "uums/menu-input";
    }

    @PostMapping("/showCodeTree")
    @ResponseBody
    public List<TreeNode> showCodeTree() {
        return menuService.findForCodeTree(null);
    }

    @PostMapping("/showOrderNum")
    @ResponseBody
    public ResponseResult genOrderNum(@RequestParam String parentCode) {
        ResponseResult result = new ResponseResult(Message.SUCCESS);
        result.setData(menuService.genOrderNum(parentCode));
        return result;
    }

    @PostMapping("/save")
    @ResponseBody
    public ResponseResult saveOrUpdate(MenuEntity menu, @RequestParam(required = false) String parentCode) {
        menuService.saveOrUpdate(menu, parentCode);
        return ResponseResult.successResult();
    }

    /**
     * 前台页面菜单展示
     * @date 2017-11-01 23:00
     */
    @PostMapping("/showMenu")
    @ResponseBody
    public ResponseResult showMenu() {
        ResponseResult result = new ResponseResult(Message.SUCCESS);
        MenuEntity menu = new MenuEntity("front", true);
        menu.setMenuCode("001%");
        result.setData(menuService.find(menu));
        return result;
    }

    @PostMapping("/nav")
    @ResponseBody
    public List<MenuEntity> nav(@RequestParam String code) {
        return menuService.findForNav(code);
    }
}

