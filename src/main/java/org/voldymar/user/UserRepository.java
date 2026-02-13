package org.voldymar.user;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {

    private final Map<Long, User> users;
    private Long idCount;


    public UserRepository() {
        users = new HashMap<>();
        idCount = 0L;
    }


    public User save(User user) {
        users.put(idCount, user);
        idCount++;
        return user;
    }


    public Optional<User> findById(Long id) {
        return Optional.ofNullable(users.get(id));
    }


    public List<User> findAll() {
        return new ArrayList<User>(users.values());
    }
}
