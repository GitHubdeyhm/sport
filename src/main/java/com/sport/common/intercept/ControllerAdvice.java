package com.sport.common.intercept;

import com.sport.common.ResponseResult;
import com.sport.common.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制层增强，实现对异常的统一处理
 * @author huangxl
 * @date 2017-09-23 22:06
 */
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    private final Logger log = LoggerFactory.getLogger(ControllerAdvice.class);
    /**
     * 自定义异常
     * @date 2017-10-04 00:28
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseResult handlerExcepation(ServiceException ex) {
        return new ResponseResult(ex.getCode(), ex.getMessage());
    }

    /**
     * 系统内部异常
     * @date 2017-10-04 00:28
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseResult handlerExcepation(Exception ex) {
        log.error("error:{}", ex);
        return ResponseResult.errorResult();
    }
}
