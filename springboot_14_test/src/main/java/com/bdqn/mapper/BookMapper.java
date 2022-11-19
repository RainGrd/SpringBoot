package com.bdqn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bdqn.entity.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author RanGrd
 * @since 2022-10-01
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
