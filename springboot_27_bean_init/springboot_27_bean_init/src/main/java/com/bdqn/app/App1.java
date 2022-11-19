package com.bdqn.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/19 14:39
 * FileName: App1
 * Description:
 */
public class App1 {
    public static void main(String[] args) {
        ApplicationContext ctc=new ClassPathXmlApplicationContext("applicationContext1.xml");
/*        Object cat = ctc.getBean("cat");
        System.out.println(cat);
        Dog dog = ctc.getBean(Dog.class);
        System.out.println("dog = " + dog);*/
        String[] names = ctc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name = " + name);
        }
    }
}
