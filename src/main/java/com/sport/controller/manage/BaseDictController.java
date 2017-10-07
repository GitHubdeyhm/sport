package com.sport.controller.manage;

import com.sport.common.Constant;
import com.sport.common.ResponseResult;
import com.sport.common.easyui.Datagrid;
import com.sport.entity.manage.BaseDictEntity;
import com.sport.service.manage.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @PostMapping("/showList")
    @ResponseBody
    public Datagrid<BaseDictEntity> findDict(@RequestParam(required = false) Integer parentId) {
//        ResponseResult<List<BaseDictEntity>> result = new ResponseResult<>(Message.SUCCESS);
        List<BaseDictEntity> dictList = baseDictService.findByParentId(parentId);
        Datagrid<BaseDictEntity> dg = new Datagrid<>(0, dictList);
        return dg;
    }
}
