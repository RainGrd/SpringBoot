package com.bdqn.service.impl;

import com.bdqn.service.BookService;
import org.springframework.stereotype.Service;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/9/28 9:55
 * FileName: BookServiceImpl
 * Description:
 */
@Service
public class BookServiceImpl implements BookService {
    @Override
    public void save() {
        System.out.println("book service is running ...");
    }
}
