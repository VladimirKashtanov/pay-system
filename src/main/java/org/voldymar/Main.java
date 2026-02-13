package org.voldymar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.voldymar.user.User;
import org.voldymar.user.UserService;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("org.voldymar");

        var userService = context.getBean(UserService.class);
        userService.createUser(new User(
                null,
                "test@domen.test",
                new HashSet<Long>()
        ));
        System.out.println("User created successfully: " + userService.getById(0L).get().email());
    }
}