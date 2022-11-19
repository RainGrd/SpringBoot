package com.bdqn.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/4 22:11
 * FileName: BookContrller
 * Description:
 */
@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {
    //创建记录日志对象
    //private static final Logger log= LoggerFactory.getLogger(BookController.class);


    @GetMapping("/getById.do")
    public String getById(){
        System.out.println("spring is running...");
        //程序员调试
        log.debug("debug...");

        log.info("info...");
        //警告
        log.warn("warn...");
        //报错信息
        log.error("error...");
        return "spring is running...";
    }

}
