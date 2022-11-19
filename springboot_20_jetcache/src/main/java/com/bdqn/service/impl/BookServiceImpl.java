package com.bdqn.service.impl;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.bdqn.entity.Book;
import com.bdqn.mapper.BookMapper;
import com.bdqn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/10 13:48
 * FileName: BookServiceImpl
 * Description:
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;


    @Override
    public int save(Book book) {
        return bookMapper.insert(book);
    }

    @Override
    @CacheUpdate(name = "book_", key = "#book.id", value = "#book")
    public int update(Book book) {
        return bookMapper.updateById(book);
    }

    @Override
    @CacheInvalidate(name = "book_", key = "#id")
    public int deleteById(Long id) {
        return bookMapper.deleteById(id);
    }

    @Override
    @Cached(name = "book_", key = "#id", expire = 3600)
    //@CacheRefresh(refresh = 10)
    public Book queryBookById(Long id) {
        /*如果当前缓存中没有本次要查询的数据，则进行查询,否则直接从缓存中获取数据返回*/
        return bookMapper.selectById(id);
    }

    @Override
    public List<Book> queryBookList(Book book) {
        LambdaQueryWrapper<Book> bookLambdaQueryWrapper = new LambdaQueryWrapper<>();
        return bookMapper.selectList(bookLambdaQueryWrapper);
    }
}
