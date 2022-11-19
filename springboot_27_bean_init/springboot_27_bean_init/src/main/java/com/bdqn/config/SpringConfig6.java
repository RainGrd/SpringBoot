package com.bdqn.config;


import com.bdqn.bean.Dog;
import com.bdqn.bean.MyImportSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/19 15:15
 * FileName: SpringConfig3
 * Description:
 */
//@Configuration
@Import(MyImportSelector.class)
@ComponentScan(basePackages = {"com.bdqn"})
public class SpringConfig6 {

}
