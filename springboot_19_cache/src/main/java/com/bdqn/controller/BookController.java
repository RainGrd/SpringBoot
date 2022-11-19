package com.bdqn.controller;

import com.bdqn.entity.Book;
import com.bdqn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/10 13:54
 * FileName: BookController
 * Description:
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;



    @GetMapping("{id}")
    public Book get(@PathVariable Long id){
        return bookService.queryBookById(id);
    }

    @PostMapping
    public int save(@RequestBody Book book){
        return bookService.save(book);
    }

    @PutMapping
    public int update(@RequestBody Book book){
        return bookService.update(book);
    }

    @DeleteMapping("{id}")
    public int delete(@RequestBody Book book){
        return bookService.save(book);
    }

    @GetMapping
    public List<Book> getAll(){
        return bookService.queryBookList(null);
    }



}
