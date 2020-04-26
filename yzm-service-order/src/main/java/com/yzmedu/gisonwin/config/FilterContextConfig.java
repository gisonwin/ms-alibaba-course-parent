package com.yzmedu.gisonwin.config;

import com.alibaba.csp.sentinel.adapter.servlet.CommonFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

/**
 * @author <a href="mailto:gisonwin@qq.com">GisonWin</a>
 * @date 2020/4/19 20:50
 */
//@Configuration
public class FilterContextConfig {
    @Bean
    public FilterRegistrationBean sentinelFilterRegistration() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new CommonFilter());
        filterFilterRegistrationBean.addUrlPatterns("/*");
        //入口资源关闭聚合
        filterFilterRegistrationBean.addInitParameter(CommonFilter.WEB_CONTEXT_UNIFY, "false");
        filterFilterRegistrationBean.setName("sentinelFilter");
        filterFilterRegistrationBean.setOrder(1);
        return filterFilterRegistrationBean;
    }
}
