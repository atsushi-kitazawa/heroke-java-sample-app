package com.atsushi.kitazawa.repository;

import com.atsushi.kitazawa.entity.User;
import com.atsushi.kitazawa.exception.UserNotFoundException;

public interface IUserRepository {
    public User getName(String name) throws UserNotFoundException;
}
