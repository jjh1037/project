package com.example.board.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shipping")
public class ShippingController {

   @GetMapping("/list")
    public String getList() {
       return "shipping/list";
   }

   @GetMapping("/write")
    public  String getView() {
       return "shipping/write";
   }


}
