package com.bdqn.service.impl;

import com.bdqn.service.MessageService;
import com.bdqn.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/11 19:07
 * FileName: OrderServiceImpl
 * Description:
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private MessageService messageService;

    @Override
    public void order(String id) {
        messageService.sendMessage(id);
        System.out.println("订单处理开始");
        /*具体业务*/
        System.out.println("订单处理结束");
    }
}
