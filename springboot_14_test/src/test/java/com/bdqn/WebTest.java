package com.bdqn;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/5 21:58
 * FileName: WebTest
 * Description:
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//开启虚拟mvc调用
@AutoConfigureMockMvc
public class WebTest {

    @Test
    void testWeb(@Autowired MockMvc mockmvc) throws Exception {

        System.out.println("mockmvc = " + mockmvc);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions perform = mockmvc.perform(builder);
        System.out.println(perform);
    }

    @Test
    void testStatus(@Autowired MockMvc mockmvc) throws Exception {
        System.out.println("mockmvc = " + mockmvc);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions perform = mockmvc.perform(builder);
        //设置预期值
        StatusResultMatchers status = MockMvcResultMatchers.status();

        //定义本次调用的预期货
        ResultMatcher ok = status.isOk();
        //预计本次调用时成功的:状态200
        System.out.println("ok = " + ok);
        //添加预计值到本次调用过程中进行调整
        ResultActions resultActions = perform.andExpect(ok);
        System.out.println("resultActions = " + resultActions);
    }

    @Test
    void testBody(@Autowired MockMvc mockmvc) throws Exception {
        System.out.println("mockmvc = " + mockmvc);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions perform = mockmvc.perform(builder);
        //设置预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();

        //定义本次调用的预期值
        ResultMatcher result = content.string("spring boot");
        //添加预计值到本次调用过程中进行调整
        ResultActions resultActions = perform.andExpect(result);
    }

    @Test
    void testJsonBody(@Autowired MockMvc mockmvc) throws Exception {
        System.out.println("mockmvc = " + mockmvc);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions perform = mockmvc.perform(builder);
        //设置预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();

        //定义本次调用的预期值
        ResultMatcher result = content.json("{\"id\":1237382973,\"name\":\"6666\",\"type\":\"小说\",\"description\":\"666\",\"deleted\":null,\"version\":null}");
        //添加预计值到本次调用过程中进行调整
        ResultActions resultActions = perform.andExpect(result);
    }

    @Test
    void testHeader(@Autowired MockMvc mockmvc) throws Exception {
        System.out.println("mockmvc = " + mockmvc);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions perform = mockmvc.perform(builder);
        //设置预期值
        HeaderResultMatchers header = MockMvcResultMatchers.header();

        //定义本次调用的预期值
        ResultMatcher result = header.string("Content-Type","application/json");
        //添加预计值到本次调用过程中进行调整
        ResultActions resultActions = perform.andExpect(result);
    }
}
