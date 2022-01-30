package com.atsushi.kitazawa.services;

import java.util.List;

import com.atsushi.kitazawa.entity.User;
import com.atsushi.kitazawa.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;

    public List<User> getUsers() {
        return userRepo.findAll();
    }
}
