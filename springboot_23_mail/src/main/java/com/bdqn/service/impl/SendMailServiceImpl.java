package com.bdqn.service.impl;

import com.bdqn.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/11 14:06
 * FileName: SendMailServiceImpl
 * Description:
 */
@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 发送人
     */
    private String from="3408396469@qq.com";
    /**
     * 接收人
     */
    private String to="duanronggui1224@163.com";
    /**
     * 标题
     */
    private String title="测试邮件";
    /**
     * 正文
     */
    private String context="测试邮件的正文内容";



    @Override
    public void sendMail() {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(title);
        message.setText(context);
        javaMailSender.send(message);
    }
}
