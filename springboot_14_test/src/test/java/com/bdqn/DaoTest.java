package com.bdqn;

import com.bdqn.entity.Book;
import com.bdqn.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/7 19:25
 * FileName: DaoTest
 * Description:
 */
@SpringBootTest
@Transactional
public class DaoTest {

    @Autowired
    private BookService bookService;

    @Test
    void testSave() {
        Book book = new Book();
        book.setName("测试101");
        book.setDescription("描述测试101");
        book.setType("测试数据");
        //book.setDeleted(0);
        //book.setVersion(1);
        System.out.println("book = " + book);
        int save = bookService.save(book);
        System.out.println("save = " + save);
    }
}
