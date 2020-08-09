package com.jiangtf.demo.config.database;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
//启用事务
@EnableTransactionManagement
public class DruidDataSourceConfig {
    private static Logger logger= LoggerFactory.getLogger(DruidDataSourceConfig.class);


    @Autowired
    private  DruidDataSourceSettings druidDataSourceSettings;

    public static  String DRIVER_CLASSNAME;

    @Bean
    public  static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return  new PropertySourcesPlaceholderConfigurer();
    }
   @Bean
    public ServletRegistrationBean druidServlet(){
        ServletRegistrationBean reg=new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
//        reg.setAsyncSupported(true);
        reg.addUrlMappings("/druid/*");
        reg.addInitParameter("allow","127.0.0.1");
//        reg.addInitParameter("deny","/deny");
        reg.addInitParameter("loginUserName","jiangtf");
        reg.addInitParameter("loginPassword","jiangtf");
        logger.info("druid console manager init : {}",reg);
        return  reg;
    }
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druic/*");
        logger.info("druid filter register :{} "+filterRegistrationBean);
        return  filterRegistrationBean;
    }

    @Bean
     public DataSource dataSource() throws  Exception{
         DruidDataSource ds=new DruidDataSource();
         ds.setDriverClassName(druidDataSourceSettings.getDriverClassName());
         DRIVER_CLASSNAME=druidDataSourceSettings.getDriverClassName();
         ds.setUrl(druidDataSourceSettings.getUrl());
         ds.setUsername(druidDataSourceSettings.getUsername());
         ds.setPassword(druidDataSourceSettings.getPassword());
         ds.setInitialSize(druidDataSourceSettings.getInitialSize());
         ds.setMinIdle(druidDataSourceSettings.getMinIdle());
         ds.setMaxIdle(druidDataSourceSettings.getMaxIdle());
         ds.setMaxActive(druidDataSourceSettings.getMaxActive());
         ds.setTimeBetweenEvictionRunsMillis(druidDataSourceSettings.getTimeBetweenEvictionRunsMillis());
         ds.setMinEvictableIdleTimeMillis(druidDataSourceSettings.getMinEvictableIdleTimeMillis());
         ds.setValidationQuery(druidDataSourceSettings.getValidationQuery());
         ds.setTestOnBorrow(druidDataSourceSettings.isTestOnBorrow());
         ds.setTestOnReturn(druidDataSourceSettings.isTestOnRetrun());
         ds.setPoolPreparedStatements(druidDataSourceSettings.isPoolPreparedStatements());
         ds.setMaxPoolPreparedStatementPerConnectionSize(druidDataSourceSettings.getMaxPoolpreparedStatementPerConnectionSize());
         ds.setFilters(druidDataSourceSettings.getFilters());
         ds.setConnectionProperties(druidDataSourceSettings.getConnectionProperties());
         logger.info("druid datasource config :{}"+ds);
         return  ds;
    }
    @Bean
   public PlatformTransactionManager transactionManager() throws  Exception{
        DataSourceTransactionManager txManger =new DataSourceTransactionManager();
       //把事务加到数据源上
        txManger.setDataSource(dataSource());
        return  txManger;


   }
}
