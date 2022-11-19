package com.bdqn.service.impl.activemp;

import com.bdqn.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/11 19:44
 * FileName: MessageServiceActivemqImpl
 * Description:
 */
//@Service
public class MessageServiceActivemqImpl implements MessageService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送的短信的订单已列入处理队列,id:"+id);
        jmsMessagingTemplate.convertAndSend("order.queue.id",id);
    }

    @Override
    public String doMessage() {
        String id = jmsMessagingTemplate.receiveAndConvert("order.queue.id",String.class);
//        System.out.println("已完成短信完成业务,id:"+id);
        return id;
    }
}
