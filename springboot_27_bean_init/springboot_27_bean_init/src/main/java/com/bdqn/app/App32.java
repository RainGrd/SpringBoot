package com.bdqn.app;

import com.bdqn.config.SpringConfig3;
import com.bdqn.config.SpringConfig32;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/19 14:39
 * FileName: App1
 * Description:
 */
public class App32 {
    public static void main(String[] args) {
        ApplicationContext ctc=new AnnotationConfigApplicationContext(SpringConfig32.class);
        String[] names = ctc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name = " + name);
        }
    }
}
