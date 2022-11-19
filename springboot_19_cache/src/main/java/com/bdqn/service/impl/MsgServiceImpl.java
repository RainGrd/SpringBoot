package com.bdqn.service.impl;

import com.bdqn.service.MsgService;

import java.util.HashMap;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/10 14:12
 * FileName: MsgServiceImpl
 * Description:
 */
public class MsgServiceImpl implements MsgService {

    private HashMap<String, String> cache = new HashMap<>();

    @Override
    public String get(String tel) {
        String code = tel.substring(tel.length() - 6);
        System.out.println("code = " + code);
        cache.put(tel, code);
        return code;
    }

    @Override
    public boolean check(String tel, String code) {
        String queryCode = cache.get(tel);
        System.out.println("queryCode = " + queryCode);
        return code.equals(queryCode);
    }
}
