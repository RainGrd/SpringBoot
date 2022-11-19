package com.bdqn.bean;

import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/19 14:33
 * FileName: Cat
 * Description:
 */
@Component("tom")
public class Cat {

    public Cat() {
    }

    int age;

    public Cat(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                '}';
    }
}
