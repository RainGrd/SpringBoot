package com.bdqn.service;

import javax.mail.MessagingException;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/11 14:04
 * FileName: SendMailService
 * Description: 发送邮件
 */
public interface SendMailService {

    void sendMail() throws MessagingException;
}
