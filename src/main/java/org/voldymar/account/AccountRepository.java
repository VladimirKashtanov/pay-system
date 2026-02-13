package org.voldymar.account;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AccountRepository {

    private final Map<Long, Account> accounts;


    public AccountRepository() {
        accounts = new HashMap<>();
    }


    public Account save(Account account) {
        accounts.put(account.id(), account);
        return account;
    }


    public Optional<Account> findById(Long id) {
        return Optional.ofNullable(accounts.get(id));
    }


    public List<Account> findAll() {
        return new ArrayList<>(accounts.values());
    }
}
