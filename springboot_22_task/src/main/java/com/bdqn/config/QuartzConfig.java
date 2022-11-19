package com.bdqn.config;

import com.bdqn.quartz.MyQuartz;
import com.sun.xml.internal.bind.v2.TODO;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/11 12:00
 * FileName: QuartzConfig
 * Description:
 */
@Configuration
public class QuartzConfig {
    //指定具体的定时任务类
    @Bean
    public JobDetail uploadTaskDetail() {
        return JobBuilder.newJob(MyQuartz.class).withIdentity("MyQuartz").storeDurably().build();
    }

    @Bean
    public Trigger uploadTaskTrigger() {
        // TODO 这里设定执行方式
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/15 * * * * ?");
        // 返回任务触发器
        return TriggerBuilder.newTrigger().forJob(uploadTaskDetail()).withIdentity("MyQuartz").withSchedule(scheduleBuilder).build();
    }
}
