package com.atsushi.kitazawa.services;

import java.util.Optional;

import com.atsushi.kitazawa.entity.User;
import com.atsushi.kitazawa.exception.UserNotFoundException;
import com.atsushi.kitazawa.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    // @Qualifier("database")
    // private IUserRepository userRepo;
    private UserRepository userRepo;

    public boolean login(User user) {
        try {
            Optional<User> optional = userRepo.findById(user.name());
            User u = optional.orElseThrow(() -> new UserNotFoundException(user.name()));
            if (u.password().equals(user.password())) {
                return true;
            }
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
