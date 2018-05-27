package com.sport.common.intercept;

import com.sport.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取项目的根路径拦截器，便于ftl页面获取根路径
 * @date 2017-5-11下午1:57:14
 */
public class GlobalInterceptor implements HandlerInterceptor {

    private final Logger log = LoggerFactory.getLogger(ControllerAdvice.class);

    //静态资源的url路径
    private static final String STATIC_URL = "/resources";

	/**
	 * 请求到达处理器Handler之前先调用preHandle()方法，如果返回false则直接返回，不会传递到下一个
	 * 拦截器。返回true则进行下一个处理节点处理
	 * @date 2017-5-11下午2:05:37
	 * @param handler
	 * @return
	 * @throws Exception
	 */
	public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        if (isStaticResources(request)) {
            return true;
        }
		log.info("进入了拦截器preHandle()方法："+request.getRequestURI());
		return true;
	}

	/**
	 * 当HandlerAdapater适配器执行完成后调用这个方法
	 * @date 2017-5-11下午2:05:37
	 * @param handler
	 * @param mav
	 * @throws Exception
	 */
	public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView mav) throws Exception {
        if (!isStaticResources(request)) {
            log.info("进入了拦截器postHandle()方法："+request.getRequestURI());
            if (mav != null) {
                //获取项目根路径，便于页面使用
                String basePath = request.getScheme() + "://" + request.getServerName()
                        + ":" + request.getServerPort() + request.getContextPath();
                mav.addObject(Constant.WEB_ROOT, basePath);
            }
        }
	}

	/**
	 * 响应完成后调用这个方法
	 * @date 2017-5-11下午2:05:37
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 */
	public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//System.out.println("进入了拦截器afterCompletion()方法");
	}

	/**
	 * 判断请求的是否是静态资源路径（css、js、图片文件）
	 * @date 2017-10-06 15:23
     * @return 静态资源返回true，否则返回false
	 */
	private boolean isStaticResources(HttpServletRequest request) {
        String url = request.getRequestURI();
        //静态资源路径
        if (url.startsWith(STATIC_URL)) {
            return true;
        }
        return false;
    }
}
