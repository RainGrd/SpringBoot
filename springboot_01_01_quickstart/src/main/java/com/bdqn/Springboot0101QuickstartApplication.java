package com.bdqn;

import com.bdqn.controller.BookController;
import com.bdqn.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Springboot0101QuickstartApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Springboot0101QuickstartApplication.class, args);
        System.out.println("run = " + run);
        //BookController runBook = (BookController) run.getBean("BookController");
        //System.out.println("runBook = " + runBook);
        BookController bookController = run.getBean(BookController.class);
        System.out.println("bookController = " + bookController);
        //User user= (User) run.getBean("user");
        //System.out.println("user = " + user);
        User user = run.getBean(User.class);
        System.out.println("user = " + user);
        //BookController runBean = run.getBean(BookController.class, runBook);
        //
        //System.out.println("runBean = " + runBean);
    }

}
