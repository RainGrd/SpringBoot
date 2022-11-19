package com.bdqn.service.impl;

import com.bdqn.entity.User;
import com.bdqn.mapper.UserMapper;
import com.bdqn.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author RainGrd
 * @since 2022-09-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
