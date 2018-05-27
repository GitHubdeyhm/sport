package com.sport.controller.manage;

import com.sport.common.ResponseResult;
import com.sport.common.easyui.Datagrid;
import com.sport.entity.manage.NewsEntity;
import com.sport.service.manage.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huangxl
 * @date 2017-10-29 22:23
 */
@RequestMapping("/manage/news")
@Controller
public class NewsController {

    @Resource
    private NewsService newsService;

    @GetMapping("/page")
    public String page() {
        return "manage/news";
    }

    @GetMapping("/input")
    public String input() {
        return "manage/news-input";
    }

    @PostMapping("/save")
    @ResponseBody
    public ResponseResult save(NewsEntity news) {
        newsService.saveOrUpdate(news);
        return ResponseResult.successResult();
    }

    @PostMapping("/showList")
    @ResponseBody
    public Datagrid<NewsEntity> showList() {
        Datagrid<NewsEntity> dg = new Datagrid<>();
        dg.setRows(newsService.find(null));
        return dg;
    }

    @GetMapping("/late")
    @ResponseBody
    public List<NewsEntity> late() {
        return newsService.findLateNews();
    }
}
