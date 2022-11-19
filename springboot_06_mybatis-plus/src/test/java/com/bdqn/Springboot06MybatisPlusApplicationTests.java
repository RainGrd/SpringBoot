package com.bdqn;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bdqn.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot06MybatisPlusApplicationTests {

    @Autowired
    private BookDao  bookDao;


    @Test
    void testGetAll() {
        System.out.println(bookDao.selectList(null));
    }

    @Test
    void testGetById() {
        System.out.println(bookDao.selectById(2L));
    }
}
