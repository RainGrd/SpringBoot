package com.bdqn;

import com.bdqn.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
class Springboot17MongodbApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void testInsert() {
        Book book = new Book();
        book.setName("测试数据01");
        book.setType("测试数据");
        book.setDescription("描述测试01");
        book.setId("fjsiafjsanhfsajffasjfjsf");
        book.setDeleted(0);
        book.setVersion(1);
        mongoTemplate.insert(book);
    }

    @Test
    void testDB() {
        System.out.println(mongoTemplate.getDb());
    }

    @Test
    void testFind() {
        List<Book> all = mongoTemplate.findAll(Book.class);
        System.out.println("all = " + all);
    }
}