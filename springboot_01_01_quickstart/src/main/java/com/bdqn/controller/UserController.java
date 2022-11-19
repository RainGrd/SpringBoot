package com.bdqn.controller;

import com.bdqn.entity.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/9/27 15:25
 * FileName: UserController
 * Description: '
 */
@Controller
@RestController
@RequestMapping("/users")
public class UserController {
    @Value("${lesson}")
    private String lesson;
    @Value("${server.port}")
    private Integer port;
    @Value("${enterprise.subject[0]}")
    private String subject_00;
    @Autowired
    private Environment environment;
    @Autowired
    private Enterprise enterprise;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String save() {
        System.out.println("user save...");
        return "{'module':'user save'}";
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Integer id) {
        System.out.println("users delete..." + id);
        return "{'module':'users delete'}";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id) {
        System.out.println(lesson);
        System.out.println(port);
        System.out.println(subject_00);

        String age = environment.getProperty("enterprise.age");
        System.out.println("age = " + age);

        System.out.println("-------------------------");
        System.out.println(enterprise);
        return "spring boot run...";
    }
}
