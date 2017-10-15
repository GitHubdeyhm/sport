package com.sport.common.intercept;

import com.sport.common.CommonCode;
import com.sport.common.ResponseResult;
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

    /**
     * 自定义异常
     * @date 2017-10-04 00:28
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseResult<String> handlerExcepation(ServiceException ex) {
        return new ResponseResult<>(CommonCode.ERROR_CODE, ex.getMessage());
    }

    /**
     * 系统内部异常
     * @date 2017-10-04 00:28
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseResult<String> handlerExcepation(Exception ex) {
        log.error(ex);
        ex.printStackTrace();
        return ResponseResult.errorResult();
    }
}
