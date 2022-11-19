package com.bdqn.service;

import com.bdqn.entity.Book;

import java.util.List;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/10 13:46
 * FileName: BookService
 * Description:
 */
public interface BookService {

    int save(Book book);

    int update(Book book);

    int deleteById(Long id);

    Book queryBookById(Long id);

    List<Book> queryBookList(Book book);


}
