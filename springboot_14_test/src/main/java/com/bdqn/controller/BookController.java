package com.bdqn.controller;

import com.bdqn.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/5 22:11
 * FileName: Bookcontroller
 * Description:
 */
@Controller
@RequestMapping("/books")
public class BookController {

    @GetMapping
    @ResponseBody
    public Book getById(){
        System.out.println("spring running...");
        Book book = new Book();
        book.setId(1237382973L);
        book.setName("666");
        book.setType("小说");
        book.setDescription("666");


        return book;
    }

}
