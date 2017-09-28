package com.sport.common.intercept;

import com.sport.common.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制层增强，实现对异常的统一处理
 * @author huangxl
 * @date 2017-09-23 22:06
 */
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    private final Logger log = Logger.getLogger(ControllerAdvice.class);

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public String handlerExcepation(ServiceException ex) {
        log.error(ex);
        return ex.getMessage();
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handlerExcepation(Exception ex) {
        log.error(ex);
        return ex.getMessage();
    }
}
