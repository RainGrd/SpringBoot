package com.bdqn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bdqn.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lenovo
* @description 针对表【t_user(用户表)】的数据库操作Mapper
* @createDate 2022-09-29 19:19:47
* @Entity com.bdqn.pojo.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {


}
