package com.bdqn.listener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/24 16:40
 * FileName: MyListener
 * Description:
 */
public class MyListener implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println("===========================");
        System.out.println(event.getTimestamp());
        System.out.println(event.getSource());
        System.out.println(event.getClass());
    }
}
