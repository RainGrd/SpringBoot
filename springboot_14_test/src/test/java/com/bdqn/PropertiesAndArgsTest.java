package com.bdqn;

import com.bdqn.testcase.pojo.BookCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.print.attribute.standard.Media;
import javax.print.attribute.standard.MediaSize;

//properties属性可以为当前测试用例添加临时的属性配置
@SpringBootTest(properties = {"test.prop=testValue1"})
class PropertiesAndArgsTest {

    @Value("${test.prop}")
    private String msg;

    @Autowired
    private BookCase bookCase;


    @Test
    void testProperties() {
        System.out.println(bookCase);
        System.out.println(msg);

    }

}
