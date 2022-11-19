package com.bdqn.service.impl.base;

import com.bdqn.service.MessageService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/11 19:09
 * FileName: MessageServiceImpl
 * Description:
 */
//@Service
public class MessageServiceImpl implements MessageService {

    private ArrayList<String> mylist=new ArrayList<>();

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送的短信的订单已列入处理队列,id:"+id);
        mylist.add(id);
    }

    @Override
    public String doMessage() {
        String remove = mylist.remove(0);
        System.out.println("已完成短信完成业务,id:"+remove);
        return remove;
    }
}
