package com.bdqn;

import com.bdqn.entity.Book;
import com.bdqn.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Springboot20JetcacheApplicationTests {

    @Autowired
    private BookMapper bookMapper;


    @Test
    void testAll() {
        List<Book> books = bookMapper.selectList(null);
        System.out.println("books = " + books);
    }

}
