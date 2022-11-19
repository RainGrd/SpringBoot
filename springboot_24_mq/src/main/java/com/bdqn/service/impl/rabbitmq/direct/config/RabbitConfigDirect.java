package com.bdqn.service.impl.rabbitmq.direct.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/12 13:29
 * FileName: RabbitConfigDirect
 * Description:
 */
//@Configuration//(proxyBeanMethods = false)
public class RabbitConfigDirect {

    /**
     * 声明队列
     * @return
     */
    @Bean
    public Queue directQueue(){
        return new Queue("direct_queue");
    }

    /**
     * 声明交换机
     * @return
     */
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }

    /**
     * 绑定交换机,指定routingKey
     * @return
     */
    @Bean
    public Binding bindingDirect(){
        return BindingBuilder.bind(directQueue()).to(directExchange()).with("direct");
    }


}
