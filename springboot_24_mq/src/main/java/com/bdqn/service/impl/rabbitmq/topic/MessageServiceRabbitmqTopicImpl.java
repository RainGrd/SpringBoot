package com.bdqn.service.impl.rabbitmq.topic;

import com.bdqn.service.MessageService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/12 13:24
 * FileName: MessageServiceRabbitmqDirectImpl
 * Description:
 */
//@Service
public class MessageServiceRabbitmqTopicImpl implements MessageService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送的短信的订单已列入处理队列(rabbitmq topic)id:"+id);
        amqpTemplate.convertAndSend("topic_exchange","topic.order.id",id);
    }

    @Override
    public String doMessage() {
        return null;
    }
}
