package com.bdqn.config;

import com.bdqn.bean.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/19 15:15
 * FileName: SpringConfig3
 * Description:
 */
@Configuration(proxyBeanMethods = false)
public class SpringConfig33 {

    @Bean
    public Cat cat(){
        return new Cat();
    }
}
