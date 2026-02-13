package org.voldymar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.voldymar.account.Account;
import org.voldymar.account.AccountService;
import org.voldymar.account.AccountStatus;
import org.voldymar.shared.service.UserWithAccountsService;
import org.voldymar.user.User;
import org.voldymar.user.UserService;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("org.voldymar");

        var userService = context.getBean(UserService.class);
        var accountService = context.getBean(AccountService.class);
        var service = context.getBean(UserWithAccountsService.class);

        userService.createUser(new User(
                0L,
                "test@test.domen",
                Set.of(0L)
        ));

        accountService.createAccount(new Account(
                0L,
                100.0,
                AccountStatus.ACTIVE,
                0L
        ));

        System.out.println("user email: " + service.getAllUsers().getFirst().email() +
                "\naccount id: " + service.getAllUsers().getFirst().accounts().stream().toList().getFirst().id());
    }
}