package com.atsushi.kitazawa.controller;

import java.util.ArrayList;
import java.util.List;

import com.atsushi.kitazawa.entity.User;


public class UserForm {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static UserForm convertToUser(User u) {
        UserForm uf = new UserForm();
        uf.setName(u.name());
        uf.setPassword(u.password());
        return uf;
    }

    public static List<UserForm> convertToUserList(List<User> userList) {
        List<UserForm> userFormList = new ArrayList<>();
        for(User u : userList) {
            UserForm userForm = convertToUser(u);
            userFormList.add(userForm);
        }
        return userFormList;
    }
}
