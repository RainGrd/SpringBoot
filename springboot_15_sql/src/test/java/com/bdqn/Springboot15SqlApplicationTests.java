package com.bdqn;

import com.bdqn.entity.Book;
import com.bdqn.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootTest
class Springboot15SqlApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BookMapper bookMapper;


    @Test
    void contextLoads() {
    }

    @Test
    void testJdbcTemplate() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from t_book");
        System.out.println("maps = " + maps);
    }

    @Test
    void testH2() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from t_book");
        System.out.println("maps = " + maps);
    }

    @Test
    void testMybatisPlusH2() {
        Book book = bookMapper.selectById(2L);
        System.out.println("book = " + book);
    }
}
