package com.bdqn.controller;

import com.bdqn.entity.SMSCode;
import com.bdqn.service.SMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/10 14:50
 * FileName: SMSCodeContrller
 * Description:
 */
@RestController
@RequestMapping("/sms")
public class SMSCodeController {
    @Autowired
    private SMSCodeService smsCodeService;
    @GetMapping("{tel}")
    public String getCode(@PathVariable String tel){
        return smsCodeService.sendCodeToSMS(tel);
    }
    @PostMapping("/checkCode.do")
    public boolean checkCode(@RequestBody SMSCode smsCode){
        return smsCodeService.checkCode(smsCode);
    }



}
