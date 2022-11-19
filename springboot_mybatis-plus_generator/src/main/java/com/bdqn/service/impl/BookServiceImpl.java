package com.bdqn.service.impl;

import com.bdqn.entity.Book;
import com.bdqn.mapper.BookMapper;
import com.bdqn.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author RainGrd
 * @since 2022-09-30
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

}
