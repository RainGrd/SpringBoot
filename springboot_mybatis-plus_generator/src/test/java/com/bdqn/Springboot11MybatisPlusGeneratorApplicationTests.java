package com.bdqn;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bdqn.entity.User;
import com.bdqn.service.IUserService;
import com.bdqn.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Springboot11MybatisPlusGeneratorApplicationTests {
    @Autowired
    private IUserService userService;


    @Test
    void contextLoads() {
        BaseMapper<User> baseMapper = userService.getBaseMapper();
        List<User> users = baseMapper.selectList(null);
        System.out.println(users);
    }

}
