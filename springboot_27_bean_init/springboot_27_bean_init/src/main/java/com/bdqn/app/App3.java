package com.bdqn.app;

import com.bdqn.config.SpringConfig3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/19 14:39
 * FileName: App1
 * Description:
 */
public class App3 {
    public static void main(String[] args) {
        ApplicationContext ctc=new AnnotationConfigApplicationContext(SpringConfig3.class);
        String[] names = ctc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name = " + name);
        }
        System.out.println(ctc.getBean("dog"));
        System.out.println(ctc.getBean("dog"));
        System.out.println(ctc.getBean("dog"));
    }
}
