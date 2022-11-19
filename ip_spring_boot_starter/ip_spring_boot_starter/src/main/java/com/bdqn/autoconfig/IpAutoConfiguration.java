package com.bdqn.autoconfig;

import com.bdqn.config.MvcConfig;
import com.bdqn.properties.IpProperties;
import com.bdqn.service.impl.IpCountServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/20 19:31
 * FileName: IpAutoConfiguration
 * Description:
 */
@Configuration
@EnableScheduling
//@EnableConfigurationProperties(IpProperties.class)
@Import({IpProperties.class,MvcConfig.class})
public class IpAutoConfiguration {

    @Bean
    public IpCountServiceImpl ipCountService(){
        return new IpCountServiceImpl();
    }
}
