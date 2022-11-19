package com.bdqn.app;

import com.bdqn.bean.Dog;
import com.bdqn.config.SpringConfig3;
import com.bdqn.config.SpringConfig4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/19 14:39
 * FileName: App1
 * Description:
 */
public class App4 {
    public static void main(String[] args) {
        ApplicationContext ctc=new AnnotationConfigApplicationContext(SpringConfig4.class);
        String[] names = ctc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name = " + name);
        }
        System.out.println("---------------------------");
        Dog dog = ctc.getBean(Dog.class);
        System.out.println("dog = " + dog);
    }
}
