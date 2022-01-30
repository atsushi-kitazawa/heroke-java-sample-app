package com.atsushi.kitazawa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.atsushi.kitazawa.entity.User;
import com.atsushi.kitazawa.exception.UserNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("database")
public class DatabaseUserRepository implements IUserRepository {

    @Autowired
    private DataSource dataSource;

    @Override
    public User getName(String name) throws UserNotFoundException {
        User user = null;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("select name, password from users where name = ?");
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                user = new User(rs.getString("name"), rs.getString("password"));
            }

        } catch (Exception e) {
            throw new UserNotFoundException(name);
        }

        if (user == null) {
            throw new UserNotFoundException(name);
        }
        return user;
    }
}
