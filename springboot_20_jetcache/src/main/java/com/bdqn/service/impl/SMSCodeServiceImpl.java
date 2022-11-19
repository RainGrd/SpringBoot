package com.bdqn.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.bdqn.entity.SMSCode;
import com.bdqn.service.SMSCodeService;
import com.bdqn.utils.CodeUtils;
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

    //@CreateCache(area = "sms",name = "jetCache",expire = 10)
    @CreateCache(name = "jetCache_",expire = 1000)
    private Cache<String,String> jetCache1;

    //@CreateCache(,name = "jetCache",expire = 10)
    //private Cache<String,String> jetCache2;

    @Override
    //@Cacheable(value = "smsCode",key = "#tel")
    public String sendCodeToSMS(String tel) {
        String code= codeUtils.generator(tel);
        jetCache1.put(tel,code);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        //取出内存的验证码与传递过来的验证码比较
        String code = jetCache1.get(smsCode.getTel());
        return smsCode.getCode().equals(code);
    }

}
