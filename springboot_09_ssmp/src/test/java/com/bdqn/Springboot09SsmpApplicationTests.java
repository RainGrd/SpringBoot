package com.bdqn;

;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bdqn.entity.Book;
import com.bdqn.mapper.BookMapper;
import com.bdqn.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Springboot09SsmpApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    void testGetById() {
  /*      Book book = new Book();
        book.setId(2L);
        Book bookById = bookService.queryBookById(1L);
        System.out.println("bookById = " + bookById);*/
        List<Book> bookList = bookService.queryBookList(null);
        System.out.println("bookList = " + bookList);
    }

    @Test
    void testPage() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "2");
        map.put("currentPage", "1");
        map.put("pageSize", "2");
        IPage<Book> bookIPage = bookService.queryBookPage(map);
        List<Book> records = bookIPage.getRecords();
        System.out.println("records = " + records);
    }


    @Test
    void testSave() {
        Book book = new Book();
        book.setName("测试04");
        book.setType("测试数据");
        book.setDescription("描述测试04");
        bookService.save(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(1576115605461823489L);
        book.setName("测试04");
        book.setType("测试数据");
        book.setDescription("描述测试06");
        book.setVersion(1);
        bookService.update(book);
    }
}
