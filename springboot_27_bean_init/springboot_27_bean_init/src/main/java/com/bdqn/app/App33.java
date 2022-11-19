package com.bdqn.app;

import com.bdqn.config.SpringConfig32;
import com.bdqn.config.SpringConfig33;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/19 14:39
 * FileName: App1
 * Description:
 */
public class App33 {
    public static void main(String[] args) {
        ApplicationContext ctc=new AnnotationConfigApplicationContext(SpringConfig33.class);
        String[] names = ctc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name = " + name);
        }
        System.out.println("==========================================");
        SpringConfig33 springConfig33 = ctc.getBean("springConfig33", SpringConfig33.class);
        System.out.println(springConfig33.cat());
        System.out.println(springConfig33.cat());
        System.out.println(springConfig33.cat());
//        System.out.println( ctc.getBean("springConfig33"));
    }
}
