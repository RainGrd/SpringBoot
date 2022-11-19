package com.bdqn.service.impl.rabbitmq.topic.listener;

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
public class MessageListener {

    @RabbitListener(queues = {"topic_queue"})
    public void receive(String id){
        System.out.println("已完成短信完成业务(rabbitMq topic 1)id:"+id);
    }

    @RabbitListener(queues = {"topic_queue2"})
    public void receive2(String id){
        System.out.println("已完成短信完成业务(rabbitMq topic 2)id:"+id);
    }


}
