package com.atsushi.kitazawa.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.atsushi.kitazawa.entity.User;
import com.atsushi.kitazawa.exception.UserNotFoundException;

import org.springframework.stereotype.Repository;

@Repository("inmemory")
public class InMemoryUserRepository implements IUserRepository {
    private final List<User> userDb = Arrays.asList(new User("user1", "pass1"),
            new User("user2", "pass2"), new User("user3", "pass3"));

    @Override
    public User getName(String name) throws UserNotFoundException {
        Optional<User> user = userDb.stream().filter(u -> u.name().equals(name)).findFirst();
        return user.orElseThrow(() -> new UserNotFoundException(name));
    }
}
