package com.bdqn.service.impl;

import com.bdqn.entity.SMSCode;
import com.bdqn.service.SMSCodeService;
import com.bdqn.utils.CodeUtils;
import lombok.SneakyThrows;
import net.rubyeye.xmemcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
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
    private MemcachedClient memcachedClient;

    /*spring boot使用 memcached*/


    @SneakyThrows
    @CachePut(value = "smsCode", key = "#tel")
    public String sendCodeToSMS(String tel) {
        String code = codeUtils.generator(tel);
        memcachedClient.set(tel,0,code);
        return code;
    }

    @SneakyThrows
    @Override
    public boolean checkCode(SMSCode smsCode) {
        //取出内存的验证码与传递过来的验证码比较
        String code=memcachedClient.get(smsCode.getTel()).toString();
        return smsCode.getCode().equals(code);
    }

    /*@Override
    //@Cacheable(value = "smsCode",key = "#tel")
    @CachePut(value = "smsCode", key = "#tel")
    public String sendCodeToSMS(String tel) {
        return codeUtils.generator(tel);
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        //取出内存的验证码与传递过来的验证码比较
        String code = smsCode.getCode();
        String cacheCode = codeUtils.getCode(smsCode.getTel());
        System.out.println(cacheCode);
        return cacheCode.equals(code);
    }*/

}
