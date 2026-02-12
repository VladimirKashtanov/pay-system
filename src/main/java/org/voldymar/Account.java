package org.voldymar;

public record Account(

        Long id,
        Double amount,
        AccountStatus status,

        Long userId
) {
}
