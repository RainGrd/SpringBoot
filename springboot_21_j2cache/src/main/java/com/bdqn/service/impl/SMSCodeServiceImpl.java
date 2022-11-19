package com.bdqn.service.impl;

import com.bdqn.entity.SMSCode;
import com.bdqn.service.SMSCodeService;
import com.bdqn.utils.CodeUtils;
import net.oschina.j2cache.CacheChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/10 14:48
 * FileName: SMSCodeServiceImpl
 * Description:
 */
@Service
public class SMSCodeServiceImpl implements SMSCodeService {


    @Autowired
    private CodeUtils codeUtils;

    @Autowired
    private CacheChannel cacheChannel;

    @Override
    public String sendCodeToSMS(String tel) {
        String code= codeUtils.generator(tel);
        cacheChannel.set("sms",tel,code);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code=cacheChannel.get("sms",smsCode.getTel()).asString();
        //取出内存的验证码与传递过来的验证码比较
        return smsCode.getCode().equals(code);
    }

}
