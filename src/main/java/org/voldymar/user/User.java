package org.voldymar.user;

import org.voldymar.account.Account;

import java.util.List;

public record User(

        Long id,
        String email,

        List<Account> accounts
        // операция
) {
}
