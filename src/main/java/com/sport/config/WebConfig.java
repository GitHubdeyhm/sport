package com.sport.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * 通过继承AbstractAnnotationConfigDispatcherServletInitializer类实现配置spring的DispatchServlet。
 * 类似web.xml文件的配置
 * AbstractAnnotationConfigDispatcherServletInitializer会同时创
 * 建DispatcherServlet和ContextLoaderListener。 getServletConfigClasses()方法返回的带有@Configuration注解的
 * 类将会用来定义DispatcherServlet应用上下文中的bean。 getRootConfigClasses()方法返回的带有@Configuration注解的类将
 * 会用来配置ContextLoaderListener创建的应用上下文中的bean。
 * @author huangxiaolin
 * @date 2017-12-29 上午11:37
 */
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    /**
     * 配置servlet拦截地址，这里设置为默认servlet
     * @author huangxiaolin
     * @date 2017-12-29 16:11
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //配置过滤器
    /*@Override
    protected Filter[] getServletFilters() {
        DelegatingFilterProxy filterProxy = new DelegatingFilterProxy();
        filterProxy.setTargetFilterLifecycle(true);
        filterProxy.setBeanName("filterProxy");
        filterProxy.setTargetBeanName("shiroFilter");//这里的值是配置ShiroFilterFactoryBean的bean名称
        return new Filter[]{filterProxy};
    }*/


    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        //配置servlet上传文件参数，单位为字节。默认没有大小限制
        MultipartConfigElement mce = new MultipartConfigElement("/tmp", 2097152, 20971520, 0);
        registration.setMultipartConfig(mce);
    }

}
