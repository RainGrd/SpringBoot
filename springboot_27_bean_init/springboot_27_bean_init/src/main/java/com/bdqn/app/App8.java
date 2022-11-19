package com.bdqn.app;

import com.bdqn.bean.service.BookService;
import com.bdqn.config.SpringConfig7;
import com.bdqn.config.SpringConfig8;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/19 14:39
 * FileName: App1
 * Description:
 */
public class App8 {
    public static void main(String[] args) {
        ApplicationContext ctc = new AnnotationConfigApplicationContext(SpringConfig8.class);
        BookService bookService = ctc.getBean("bookService", BookService.class);
        bookService.check();
    }
}
