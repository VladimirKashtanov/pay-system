package org.voldymar.shared.dto;

import org.voldymar.account.Account;

import java.util.Set;

public record UserWithAccounts(

        Long id,
        String email,

        Set<Account> accounts
) {
}
