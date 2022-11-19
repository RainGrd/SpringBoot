package com.bdqn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bdqn.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/9/28 10:19
 * FileName: BookDao
 * Description:
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {
    /*@Select("select * from t_book where id=#{id} ;")
    Book getById(Integer id);*/
}
