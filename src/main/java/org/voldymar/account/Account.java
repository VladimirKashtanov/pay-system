package org.voldymar.account;

public record Account(

        Long id,
        Double amount,
        AccountStatus status,

        Long userId
) {
}
