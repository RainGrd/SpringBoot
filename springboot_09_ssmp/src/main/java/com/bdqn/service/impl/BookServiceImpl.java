package com.bdqn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.entity.Book;
import com.bdqn.mapper.BookMapper;
import com.bdqn.service.BookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author RanGrd
 * @since 2022-10-01
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    private Counter counter;

    public BookServiceImpl(MeterRegistry meterRegistry){
        counter = meterRegistry.counter("用户付费操作次数");
        System.out.println("counter = " + counter);
    }

    LambdaQueryWrapper<Book> bookLambdaQueryWrapper = new LambdaQueryWrapper<Book>();

    @Override
    public int save(Book book) {
        return bookMapper.insert(book);
    }

    @Override
    public int update(Book book) {
        return bookMapper.updateById(book);
    }

    @Override
    public int deleteById(Long id) {
        /*metrics操作*/
        counter.increment();
        return bookMapper.deleteById(id);
    }

    @Override
    public Book queryBookById(Long id) {
        return bookMapper.selectById(id + "L");
    }

    @Override
    public List<Book> queryBookList(Book book) {
        LambdaQueryWrapper<Book> bookLambdaQueryWrapper = new LambdaQueryWrapper<>();

        return bookMapper.selectList(bookLambdaQueryWrapper);
    }

    /**
     * 分页查询
     *
     * @param map
     * @return
     */

    @Override
    public IPage<Book> queryBookPage(Map<String, String> map) {
        int current = Integer.parseInt(map.get("currentPage"));
        int pageSize = Integer.parseInt(map.get("pageSize"));
        LambdaQueryWrapper<Book> bookLambdaQueryWrapper = new LambdaQueryWrapper<>();
        String name = map.get("name");
        String type = map.get("type");
        String description = map.get("description");
        bookLambdaQueryWrapper.like(Strings.isNotEmpty(name), Book::getName, name);
        bookLambdaQueryWrapper.like(Strings.isNotEmpty(type), Book::getType, type);
        bookLambdaQueryWrapper.like(Strings.isNotEmpty(description), Book::getDescription, description);
        IPage<Book> bookIPage = new Page<>(current, pageSize);
        bookMapper.selectPage(bookIPage, bookLambdaQueryWrapper);
        //如果当前页码值大于总页码数值,那么重新执行查询操作,使用最大页码值作为当前页码值
        if (current > bookIPage.getPages()) {
            bookIPage = new Page<>(bookIPage.getPages(), pageSize);
            bookIPage = bookMapper.selectPage(bookIPage, bookLambdaQueryWrapper);
        }
        return bookIPage;
    }

}
