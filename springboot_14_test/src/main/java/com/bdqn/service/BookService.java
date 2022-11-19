package com.bdqn.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bdqn.entity.Book;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author RanGrd
 * @since 2022-10-01
 */
public interface BookService {

    int save(Book book);

    int update(Book book);

    int deleteById(Long id);

    Book queryBookById(Long id);

    List<Book> queryBookList(Book book);

    IPage<Book> queryBookPage(Map<String,String> map);


}
