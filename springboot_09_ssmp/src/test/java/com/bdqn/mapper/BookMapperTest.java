package com.bdqn.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/1 13:01
 * FileName: BooKMapperTest
 * Description:
 */
@SpringBootTest
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;


    @Test
    void testGetAll() {
/*        List<Book> books = bookMapper.selectList(null);
        System.out.println("books = " + books);*/
        LambdaQueryWrapper<Book> bookLambdaQueryWrapper = new LambdaQueryWrapper<>();
        bookLambdaQueryWrapper.like(Book::getName, "2");
        List<Book> books = bookMapper.selectList(bookLambdaQueryWrapper);
        System.out.println("books = " + books);
    }

    @Test
    void testConditions() {
        LambdaQueryWrapper<Book> bookLambdaQueryWrapper = new LambdaQueryWrapper<>();
        /*查询投影*/
/*        bookLambdaQueryWrapper.select(Book::getName,Book::getDescription);
       */
        /*条件查询*/
/*        bookLambdaQueryWrapper.between(Book::getId,1,2);
       */
        bookLambdaQueryWrapper.le(Book::getId,"2");
        List<Book> books = bookMapper.selectList(bookLambdaQueryWrapper);
        System.out.println("books = " + books);
    }

    @Test
    void testGetPage() {
        LambdaQueryWrapper<Book> bookLambdaQueryWrapper = new LambdaQueryWrapper<>();
        IPage<Book> bookPage = new Page<>(1, 1);
        IPage<Book> bookIPage = bookMapper.selectPage(bookPage, bookLambdaQueryWrapper);
        System.out.println(bookIPage.getRecords());
    }
}
