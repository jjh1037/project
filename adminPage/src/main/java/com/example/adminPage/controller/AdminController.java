package com.example.adminPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class AdminController {

    @GetMapping("")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/ex")
    public String getEx() {
        return "ex";
    }



}
