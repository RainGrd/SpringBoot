package com.bdqn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/5 21:42
 * FileName: MsgConfig
 * Description:
 */
@Configuration
public class MsgConfig {


    @Bean
    public String msg(){
        return "bean mes";
    }
}
