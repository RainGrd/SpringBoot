package com.bdqn.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.bdqn.bean.Cat;
import com.bdqn.bean.Dog;
import com.bdqn.bean.Mouse;
import com.bdqn.bean.MyImportSelector;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Import;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/19 20:09
 * FileName: SpringConfig
 * Description:
 */
//@Import(MyImportSelector.class)
//@Import(Mouse.class)
@ComponentScan("com.bdqn.bean")
public class SpringConfig {

/*    @Bean
//    @ConditionalOnClass(name="com.bdqn.bean.Wolf")
//    @ConditionalOnMissingClass("com.bdqn.bean.Mouse")
    @ConditionalOnBean(name = "jerry")
//    @ConditionalOnMissingClass("com.bdqn.bean.Dog")
@ConditionalOnNotWebApplication
    @ConditionalOnWebApplication

    public Cat tom() {
        return new Cat();
    }*/

    @Bean
    @ConditionalOnClass(name = "com.mysql.cj.jdbc.Driver")
    public DruidDataSource dataSource(){
        return new DruidDataSource();
    }

}
