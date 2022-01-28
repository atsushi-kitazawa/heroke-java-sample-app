package com.atsushi.kitazawa.controller;

import com.atsushi.kitazawa.entity.User;
import com.atsushi.kitazawa.services.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    private LoginService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("user", new UserForm());
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute UserForm user, Model model) {
        User u = new User(user.getName(), user.getPassword());
        if (service.login(u)) {
            model.addAttribute("name", user.getName());
            return "login_success";
        } else {
            model.addAttribute("name", user.getName());
            return "login_fail";
        }
    }
}
