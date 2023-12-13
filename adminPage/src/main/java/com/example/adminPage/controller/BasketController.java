package com.example.adminPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasketController {
    @GetMapping("/userpage/u_basket")
    public String getUBasket() {
        return "userpage/u_basket";
    }
}
