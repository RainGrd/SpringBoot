package com.bdqn.app;

import com.bdqn.bean.Cat;
import com.bdqn.bean.Dog;
import com.bdqn.bean.Mouse;
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
public class App5 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctc = new AnnotationConfigApplicationContext(SpringConfig4.class);
        // 上下文容器对象已经初始化完毕，手工加载bean
        ctc.registerBean("tom", Cat.class, 0);
        ctc.registerBean("tom", Cat.class, 1);
        ctc.registerBean("tom", Cat.class, 2);
        ctc.register(Mouse.class);
        String[] names = ctc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name = " + name);
        }
        System.out.println("---------------------------");
        System.out.println(ctc.getBean(Cat.class));
    }
}
