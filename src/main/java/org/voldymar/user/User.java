package org.voldymar.user;

import java.util.Set;

public record User(

        Long id,
        String email,

        Set<Long> accountIds
) {
}
