package com.bdqn.config;


import com.bdqn.bean.Dog;
import org.springframework.context.annotation.Import;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/19 15:15
 * FileName: SpringConfig3
 * Description:
 */
@Import({Dog.class,DataSourceConfig.class})
public class SpringConfig4 {


}
