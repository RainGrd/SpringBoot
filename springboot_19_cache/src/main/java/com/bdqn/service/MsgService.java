package com.bdqn.service;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/10 14:11
 * FileName: MsgService
 * Description:
 */
public interface MsgService {

    String get(String tel);

    boolean check(String tel, String code);

}
