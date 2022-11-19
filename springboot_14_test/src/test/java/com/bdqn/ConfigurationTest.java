package com.bdqn;

import com.bdqn.config.MsgConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/5 21:46
 * FileName: ConfigurationTest
 * Description:
 */
@SpringBootTest
@Import({MsgConfig.class})
public class ConfigurationTest {
    @Autowired
    private String message;


    @Test
    void testMsgConfig() {
        System.out.println(message);
    }
}
