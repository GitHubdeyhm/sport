package com.sport.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sport.common.Constant;
import com.sport.util.DateUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

/**
 * 注解EnableWebMvc启用springmvc功能
 * @author huangxiaolin
 * @date 2017-12-29 下午4:23
 */
@Configuration
@EnableWebMvc
//@EnableAspectJAutoProxy//启用切面aspect注解
@ComponentScan("com.sport.controller")//注解扫描
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 配置视图解析器
     * @author huangxiaolin
     * @date 2017-12-29 16:37
     */
    @Bean
    ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }



    /**
     * 配置文件上传解析，结合WebConfig类的MultipartConfigElement配置
     * @author huangxiaolin
     * @date 2018-01-08 17:41
     */
    @Bean
    MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

    //@Bean
    //public Validator validator() {
    //    Validator localValidatorFactoryBean = new LocalValidatorFactoryBean();
    //    return localValidatorFactoryBean;
    //}

    @Bean
    FreeMarkerViewResolver freeMarkerViewResolver() {
        FreeMarkerViewResolver fvs = new FreeMarkerViewResolver();
        fvs.setSuffix(".ftl");
        fvs.setOrder(5);
        fvs.setContentType("text/html;charset=UTF-8");
        return fvs;
    }

    @Bean
    FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer fc = new FreeMarkerConfigurer();
        fc.setTemplateLoaderPath("/WEB-INF/templates/");
        fc.setDefaultEncoding(Constant.CHARSET_UTF8);
        Properties settings = new Properties();
        settings.setProperty("classic_compatible", "true");
        settings.setProperty("boolean_format", "true,false");
        settings.setProperty("number_format", "0.##");
        settings.setProperty("datetime_format", DateUtil.DATE_TIME_PATTERN);
        fc.setFreemarkerSettings(settings);
        return fc;
    }

    /**
     * 配置拦截器
     * @author huangxiaolin
     * @date 2018-01-11 17:34
     */
    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new FormTokenInterceptor()).addPathPatterns("*//**");
    }*/

    /**
     * 重写springmvc的jackosn配置，覆盖默认的配置。
     * 通过Jackson2ObjectMapperBuilder配置默认会增加两个配置：
     * DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES=false
     * DEFAULT_VIEW_INCLUSION=false
     * @author huangxiaolin
     * @date 2018-01-16 13:59
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
        //        .dateFormat(new SimpleDateFormat(DateUtil.DATE_TIME_PATTERN));//设置默认日期格式化

        ObjectMapper om = new ObjectMapper();
        //设置解析json串为对象时忽略json串多余的字段（对象没有该字段），否则会抛出异常
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //设置当对象解析为json串时对象里没有字段或者没提供字段的get方法时不抛出异常
        om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //设置默认的日期格式化，其他格式可以通过注解@JsonFormat(pattern = DateUtil.DATE_TIME_PATTERN)指定
        om.setDateFormat(new SimpleDateFormat(DateUtil.DATE_TIME_NOSECONDS_PATTERN));
        //设置当字符串为null时转换为空字符串""
        //om.setSerializerFactory(om.getSerializerFactory().withSerializerModifier(new JacksonBeanSerializerModifier()));
        converters.add(new MappingJackson2HttpMessageConverter(om));

        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        stringHttpMessageConverter.setWriteAcceptCharset(false);
        converters.add(stringHttpMessageConverter);
        //converters.add(new MappingJackson2XmlHttpMessageConverter(builder.xml().build()));
    }

    /**
     * 添加ajax跨域支持，对于前后端分离开发有用
     * @author huangxiaolin
     * @date 2018-01-16 10:24
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("*")
                .allowedOrigins("*")
                .allowedMethods("OPTIONS", "GET", "POST")
                .allowedHeaders("*");
    }

    /**
     * 配置静态资源的处理。这里对静态资源的处理交给web容器的默认servlet处理
     * @author huangxiaolin
     * @date 2017-12-29 16:36
     */
    /*@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }*/

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/");
    }
}
