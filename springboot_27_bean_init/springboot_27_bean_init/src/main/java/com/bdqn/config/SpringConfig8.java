package com.bdqn.config;


import com.bdqn.app.App5;
import com.bdqn.bean.Mouse;
import com.bdqn.bean.MyPostProcessor;
import com.bdqn.bean.MyRegistrar;
import com.bdqn.bean.MyRegistrar2;
import com.bdqn.bean.service.BookService;
import com.bdqn.bean.service.impl.BookServiceImpl1;
import org.springframework.context.annotation.Import;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/19 15:15
 * FileName: SpringConfig3
 * Description:
 */
@Import({BookServiceImpl1.class,MyRegistrar.class, MyRegistrar2.class, MyPostProcessor.class, Mouse.class})
public class SpringConfig8 {

}
