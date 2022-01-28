package com.atsushi.kitazawa.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String productList(Model model) {
        // model.addAttribute("id", 1);
        // model.addAttribute("name", "heroku");
        List<Product> list = Arrays.asList(new Product("1", "heroku1"), new Product("2", "heroku2"));
        model.addAttribute("list", list);
        return "product";
    }

    class Product {
        private String id;
        private String name;

        public Product(String id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Product [id=" + id + ", name=" + name + "]";
        }

    }
}
