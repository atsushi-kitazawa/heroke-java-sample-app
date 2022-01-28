package com.atsushi.kitazawa.services;

import com.atsushi.kitazawa.entity.User;
import com.atsushi.kitazawa.exception.UserNotFoundException;
import com.atsushi.kitazawa.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private IUserRepository userRepo;

    public boolean login(User user) {
        try {
            User u = userRepo.getName(user.name());
            if (u.password().equals(user.password())) {
                return true;
            }
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
