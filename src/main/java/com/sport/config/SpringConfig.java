package com.sport.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * spring相关配置
 * @author huangxiaolin
 * @date 2017-12-29 下午4:23
 */
@Configuration
@PropertySource(value = "classpath:application.properties")
@EnableTransactionManagement//启动数据库事务
@ComponentScan(basePackages = "com.sport", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = EnableWebMvc.class)
})//启用组件扫描，排除webmvc配置的类
public class SpringConfig implements EnvironmentAware {

    private Environment env;

    /**
     * 这里必须实现EnvironmentAware接口否则注入的env为null
     * @author huangxiaolin
     * @date 2018-01-02 14:23
     */
    @Autowired
    @Override
    public void setEnvironment(Environment env) {
        this.env = env;
    }

    /**
     * dbcp连接池配置
     * @author huangxiaolin
     * @date 2018-01-09 15:12
     */
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));

        dataSource.setValidationQuery("select 1");
        //是否从连接池中取出连接前进行检验，值为true代表检验失败时从池中删除该连接并尝试取出一个新的连接。
        //设置为true由于每次取出时都会检查连接会降低性能。不会出现mysql 8小时问题。
        //设置为false则会出现mysql 8小时问题。需配合参数testWhileIdle解决。
        dataSource.setTestOnBorrow(false);
        dataSource.setTestWhileIdle(true);
        //设置回收连接线程多长时间执行一次
        //设置的时间应该MinEvictableIdleTimeMillis+TimeBetweenEvictionRunsMillis<=mysql默认的8小时。mysql参数wait_timeout的值
        dataSource.setTimeBetweenEvictionRunsMillis(7200000);//单位：毫秒7200000=1000*60*60*2
        //连接池空闲连接的有效时间，默认为30分钟
        //dataSource.setMinEvictableIdleTimeMillis(1800000);//30分钟
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sessionFactoryBean(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        //分页插件
        PageInterceptor pi = new PageInterceptor();
        //设置分页参数，及时没有参数设置也应该调用pi.setProperties(pagePro);方法
        Properties pagePro = new Properties();
        pi.setProperties(pagePro);

        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pi});

        //获取配置文件中mybatis的映射配置文件路径
        String mapperLocations = env.getProperty("mybatis.mapper-locations");
        if (StringUtils.isEmpty(mapperLocations)) {
            mapperLocations = "classpath:mybatis/mapper/*.xml";//设置默认路径
        }
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resourceResolver.getResources(mapperLocations);
        sqlSessionFactoryBean.setMapperLocations(resources);

        org.apache.ibatis.session.Configuration cfg = new org.apache.ibatis.session.Configuration();
        cfg.setMapUnderscoreToCamelCase(true);//驼峰写法
        sqlSessionFactoryBean.setConfiguration(cfg);
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScanner() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setSqlSessionFactoryBeanName("sessionFactoryBean");
        msc.setBasePackage("com.sport.dao");
        return msc;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryBean.getObject());
    }

    /**
     * 配置事务
     * @author huangxiaolin
     * @date 2018-01-02 10:43
     */
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /*@Bean
    public AnnotationAwareAspectJAutoProxyCreator aspectjProxy() {
        AnnotationAwareAspectJAutoProxyCreator aspectjProxy = new AnnotationAwareAspectJAutoProxyCreator();
        return aspectjProxy;
    }*/

}
