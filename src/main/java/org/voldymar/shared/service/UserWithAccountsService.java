package org.voldymar.shared.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.voldymar.account.Account;
import org.voldymar.account.AccountService;
import org.voldymar.shared.dto.UserWithAccounts;
import org.voldymar.user.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class UserWithAccountsService {

    private final UserService userService;
    private final AccountService accountService;


    @Autowired
    public UserWithAccountsService(
            UserService userService,
            AccountService accountService
    ) {
        this.userService = userService;
        this.accountService = accountService;
    }


    public List<UserWithAccounts> getAllUsers() {
        var usersWithAccounts = new ArrayList<UserWithAccounts>();

        for (var user : userService.getAll()) {
            var accounts = new HashSet<Account>();

            for (var accountId : user.accountIds()) {
                var AccountOpt = accountService.getById(accountId);
                AccountOpt.ifPresent(accounts::add);
            }

            usersWithAccounts.add(new UserWithAccounts(
                    user.id(),
                    user.email(),
                    accounts
            ));
        }

        return usersWithAccounts;
    }
}
