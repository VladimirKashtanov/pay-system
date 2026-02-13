package org.voldymar.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;


    @Autowired
    public UserService(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }


    public User createUser(User user) {
        var existing = userRepository.findById(user.id());
        if (existing.isPresent()) {
            throw new IllegalArgumentException("User with e-mail=\"" +
                    existing.get().email() + "\" already exists");
        }

        return userRepository.save(user);
    }


    public List<User> getAll() {
        return userRepository.findAll();
    }


    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }
}
