package com.bdqn.springboot_08_mybatis;

import com.bdqn.dao.BookDao;
import com.bdqn.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot08MybatisApplicationTests {
    @Autowired
    private BookDao bookDao;

    @Test
    void getByIdTest() {
        Book book = bookDao.getById(1);
        System.out.println("book = " + book);
    }

}
