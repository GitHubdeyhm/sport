package com.sport.controller.manage;

import com.sport.common.Constant;
import com.sport.common.ResponseResult;
import com.sport.entity.manage.BaseDictEntity;
import com.sport.service.manage.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huangxl
 * @date 2017-10-05 11:46
 */
@RequestMapping("/manage/dict")
@Controller
public class BaseDictController {

    @Autowired
    private BaseDictService baseDictService;

    @GetMapping("/page")
    public String page(HttpServletRequest request) {
        request.setAttribute(Constant.HTML_TITLE_KEY, "系统设置");
        return "manage/baseDict";
    }


    @PostMapping("/save")
    public ResponseResult<String> save(BaseDictEntity dict) {
        baseDictService.saveOrUpdate(dict);
        return ResponseResult.successResult();
    }
}
