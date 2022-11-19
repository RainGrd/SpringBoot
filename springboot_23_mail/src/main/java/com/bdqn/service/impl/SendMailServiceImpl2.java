package com.bdqn.service.impl;

import com.bdqn.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/11 14:06
 * FileName: SendMailServiceImpl
 * Description:
 */
public class SendMailServiceImpl2 implements SendMailService {

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
    private String context="a< href='https://www.baidu.com'>点击查看</a>";



    @Override
    public void sendMail() throws MessagingException {
        MimeMessage message= javaMailSender.createMimeMessage();
        /*允许添加附件*/
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(message,true);
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(title);
        /*开启html文本模式*/
        mimeMessageHelper.setText(context,true);
        javaMailSender.send(message);
    }
}
