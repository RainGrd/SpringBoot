package com.bdqn.bean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/19 20:06
 * FileName: Cat
 * Description:
 */
@Component("tom")
@ConditionalOnBean(name = "jerry")
//@ConditionalOnWebApplication
@ConditionalOnNotWebApplication
public class Cat {
}
