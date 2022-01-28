package com.atsushi.kitazawa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String productList(Model model) {
        model.addAttribute("id", 1);
        model.addAttribute("name", "heroku");
        return "product";
    }
}
