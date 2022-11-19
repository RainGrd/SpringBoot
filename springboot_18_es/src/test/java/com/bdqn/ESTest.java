package com.bdqn;

import com.bdqn.entity.User;
import com.bdqn.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
//import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/10 9:32
 * FileName: ESTest
 * Description:
 */
@SpringBootTest
public class ESTest {

    @Resource
    private ElasticsearchRestTemplate template;

    @Autowired
    private UserMapper userMapper;

    //创建索引
    @Test
    public void createIndex() {
        //创建User对象的索引，事实上，系统初始化会自动创建索引
        boolean b = template.indexOps(User.class).create();
        System.out.println(b);
    }
    //删除索引
    @Test
    public void deleteIndex() {
        boolean b = template.indexOps(User.class).delete();
        System.out.println(b);
    }

    //新增文档
    @Test
    public void createMapping() {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        user.setAge(18);
        user.setSex(false);
        User save = userMapper.save(user);
        System.out.println(save);
    }
    //查看全部文档
    @Test
    public void findAll() {
        Iterable<User> all = userMapper.findAll();
        System.out.println(all);
    }
    //按条件查询
    @Test
    public void findCondition() {
        //按照条件查询，需要自己去自定义查询方法
        //这里使用自定义的根据姓名和价格的查询方法
        List<User> list = userMapper.findAllByNameAndAge("张三", 18);
        System.out.println(list);
    }


}
