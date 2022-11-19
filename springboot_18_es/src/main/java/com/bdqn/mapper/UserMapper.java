package com.bdqn.mapper;

import com.bdqn.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
/*import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;*/

import java.util.List;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/10 10:03
 * FileName: UserMapper
 * Description:
 */
public interface UserMapper extends ElasticsearchRepository<User,Integer> {
    //自定义查询方法
    List<User> findAllByNameAndAge(String name, Integer age);
}
