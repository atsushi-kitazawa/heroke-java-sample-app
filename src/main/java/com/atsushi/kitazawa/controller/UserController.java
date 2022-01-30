package com.atsushi.kitazawa.controller;

import java.util.List;

import com.atsushi.kitazawa.entity.User;
import com.atsushi.kitazawa.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    
    @Autowired
    UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(Model model) {
        List<User> users = userService.getUsers();
        List<UserForm> userForms = UserForm.convertToUserList(users);
        model.addAttribute("userForms", userForms);
        return "all_users_show";
    }
}
