package com.bdqn.service;

import com.bdqn.entity.SMSCode;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/10 14:47
 * FileName: SMSCodeService
 * Description:
 */
public interface SMSCodeService {
    /**
     * 获取操作验证码操作
     * @param tel
     * @return
     */
    String sendCodeToSMS(String tel);
    /**
     * 校验操作
     */
    boolean checkCode(SMSCode smsCode);


}
