package com.sport.common.listener;

import com.sport.common.Constant;
import com.sport.entity.manage.AccessCountEntity;
import com.sport.service.manage.AccessCountService;
import com.sport.util.SpringUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;

/**
 * @author huangxl
 * @date 2017-10-04 14:19
 */
@WebListener
public class SystemListener implements ServletContextListener{

    private int count = 0;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        AccessCountService accessCountService = SpringUtil.getBean(AccessCountService.class);
        sce.getServletContext().setAttribute(Constant.ACCESS_COUNT_KEY, accessCountService.getLateCount());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        AccessCountService accessCountService = SpringUtil.getBean(AccessCountService.class);
        AccessCountEntity accessCount = new AccessCountEntity();
        accessCount.setCountDate(new Date());
        accessCount.setCount((Integer) sce.getServletContext().getAttribute(Constant.ACCESS_COUNT_KEY));
        accessCount.setCount(100);
        accessCountService.save(accessCount);
    }

    private synchronized int getAccessCount() {
        return count++;
    }
}
