package com.chaoyous.readnote.config;


import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/10
 */
@Configuration
public class DruidConfig {

/*    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }*/
    //driud后台监控
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> params = new HashMap<>();
        params.put("loginUsername","admin");
        params.put("loginPassword","199747");
        params.put("allow","");
        bean.setInitParameters(params);
        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> params = new HashMap<>();
        params.put("exclusions","/druid/*");
        bean.setInitParameters(params);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }



}
