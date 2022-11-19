package com.bdqn.config;

import com.bdqn.bean.Dog;
import com.bdqn.bean.DogFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/19 15:15
 * FileName: SpringConfig3
 * Description:
 */
@ComponentScan({"com.bdqn.bean","com.bdqn.config"})
public class SpringConfig3 {


    @Bean
    public DogFactoryBean dog(){
        return new DogFactoryBean();
    }


}
