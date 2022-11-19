package com.bdqn.service.impl.rabbitmq.topic.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/12 13:29
 * FileName: RabbitConfigDirect
 * Description:
 */
//@Configuration
public class RabbitConfigTopic {

    /**
     * 声明队列
     * @return
     */
    @Bean
    public Queue topicQueue(){
        return new Queue("topic_queue");
    }

    @Bean
    public Queue topicQueue2(){
        return new Queue("topic_queue2");
    }

    /**
     * 声明交换机
     * @return
     */
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topic_exchange");
    }

    /**
     * 绑定交换机,指定routingKey
     * @return
     */
    @Bean
    public Binding bindingTopic(){
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("topic.*.id");
    }

    @Bean
    public Binding bindingTopic2(){
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("topic.orders.*");
    }

}
