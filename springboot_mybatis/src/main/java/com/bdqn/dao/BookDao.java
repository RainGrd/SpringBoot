package com.bdqn.dao;

import com.bdqn.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/9/28 10:19
 * FileName: BookDao
 * Description:
 */
@Mapper
public interface BookDao {
    @Select("select * from t_book where id=#{id} ;")
    Book getById(Integer id);
}
