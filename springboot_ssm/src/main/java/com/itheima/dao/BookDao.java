package com.itheima.dao;

import com.itheima.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

// TODO 添加@Mapper
@Mapper
public interface BookDao {
    @Insert("insert into t_book (id,type,name,description) values(#{id} ,#{type},#{name},#{description})")
    public int save(Book book);

    @Update("update t_book set type = #{type}, name = #{name}, description = #{description} where id = #{id}")
    public int update(Book book);

    @Delete("delete from t_book where id = #{id}")
    public int delete(Integer id);

    @Select("select * from t_book where id = #{id}")
    public Book getById(Integer id);

    @Select("select * from t_book")
    public List<Book> getAll();
}
