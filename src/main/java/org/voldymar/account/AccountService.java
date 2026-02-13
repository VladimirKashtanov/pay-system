package org.voldymar.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

        private final AccountRepository accountRepository;


        @Autowired
        public AccountService(AccountRepository accountRepository) {
            this.accountRepository = accountRepository;
        }


        public Account createAccount(Account account) {
            return accountRepository.save(account);
        }


        public List<Account> getAllAccounts() {
            return accountRepository.findAll();
        }


        public Optional<Account> getById(Long id) {
            return accountRepository.findById(id);
        }
}
