package com.bdqn.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/11 12:37
 * FileName: MyBean
 * Description:
 */
@Component
public class MyBean {


    @Scheduled(cron = "0/1 * * * * ?")
    public void print(){
        System.out.println("spring boot task run ....");
    }

}
