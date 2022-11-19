package com.bdqn.service.impl.kafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/12 13:40
 * FileName: MessageListener
 * Description:
 */
@Component
public class MessageListener {

    @KafkaListener(topics = {"bdqn"})
    public void onMessage(ConsumerRecord<String, String> record) {
        System.out.println("已完成短信完成业务(kafka)id:" + record.value());
    }


}
