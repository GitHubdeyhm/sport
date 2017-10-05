package com.sport.common.exception;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义处理springmvc的异常
 * @author huangxl
 * @date 2017-10-04 23:58
 */
public class ExceptionResolver implements HandlerExceptionResolver {

    private final Logger log = Logger.getLogger(ExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        System.out.println("进入了处理异常方法---------");
        //配置发生异常跳转的页面
        ModelAndView mav = new ModelAndView("error/eror404");
//        mav.addObject("ex", ex);
        e.printStackTrace();
        log.error(e);
        return mav;
    }
}
