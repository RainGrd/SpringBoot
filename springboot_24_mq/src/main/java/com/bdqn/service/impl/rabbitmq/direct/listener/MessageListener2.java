package com.bdqn.service.impl.rabbitmq.direct.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/12 13:40
 * FileName: MessageListener
 * Description:
 */
//@Component
public class MessageListener2 {

    @RabbitListener(queues = {"direct_queue"})
    public void receive(String id){
        System.out.println("已完成短信完成业务(rabbitMq direct two)id:"+id);
    }


}
