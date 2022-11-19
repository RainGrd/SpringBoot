package com.bdqn.utils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/10 14:54
 * FileName: CodeUtils
 * Description:
 */
@Component
public class CodeUtils {
    private  String[] patch = {"00000", "0000", "000", "00", "0", ""};

    /**
     * 计算六位的验证码
     */
    public  String generator(String tel) {
        int hashCode = tel.hashCode();
        int encryption = 2022666;
        long result = hashCode ^ encryption;
        long nowTime = System.currentTimeMillis();
        result = result ^ nowTime;
        long code = result % 1000000;
        code = code < 0 ? -code : code;
        String codeStr = code + "";
        int length = codeStr.length();
        return patch[length-1] + codeStr;
    }
    /**
     * 获取放在缓存中的验证码
     */
    @Cacheable(value = "smsCode",key = "#tel")
    public String getCode(String tel){
        return null;
    }

}
