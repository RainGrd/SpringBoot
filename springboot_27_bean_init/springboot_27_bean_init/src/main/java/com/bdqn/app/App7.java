package com.bdqn.app;

import com.bdqn.config.SpringConfig6;
import com.bdqn.config.SpringConfig7;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/19 14:39
 * FileName: App1
 * Description:
 */
public class App7 {
    public static void main(String[] args) {
        ApplicationContext ctc = new AnnotationConfigApplicationContext(SpringConfig7.class);
        String[] names = ctc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name = " + name);
        }
    }
}
