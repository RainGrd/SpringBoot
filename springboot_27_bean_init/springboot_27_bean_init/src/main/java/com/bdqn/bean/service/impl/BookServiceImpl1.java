package com.bdqn.bean.service.impl;

import com.bdqn.bean.service.BookService;
import org.springframework.stereotype.Service;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/19 14:34
 * FileName: BookServiceImpl1
 * Description:
 */
@Service("bookService")
public class BookServiceImpl1 implements BookService {
    @Override
    public void check() {
        System.out.println("book service 1...");
    }
}
