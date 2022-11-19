package com.bdqn.config;

import com.bdqn.interceptor.IpCountInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/24 12:04
 * FileName: MvcConfig
 * Description:
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public IpCountInterceptor IpCountInterceptor(){
        return new IpCountInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(IpCountInterceptor()).addPathPatterns("/**");
    }


}
