package com.example.adminPage.controller;

import com.example.adminPage.mappers.UserShippingMapper;
import com.example.adminPage.service.UserShippingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserShippingMapper userShippingMapper;

    @Autowired
    UserShippingListService userShippingListService;

    @Value("${fileDir}")
    String fileDir;

    @GetMapping("/u_shippingList")
    public String getUshippingList(Model model,
                                   @RequestParam(value="searchType", defaultValue = "") String searchType,
                                   @RequestParam(value="words", defaultValue = "") String words,
                                   @RequestParam(value = "page", defaultValue = "1") int page) {

        model.addAttribute("cnt", userShippingListService.getSearchCnt(searchType, words));
        model.addAttribute("list", userShippingListService.getSearch(page, searchType, words));
        model.addAttribute("page", userShippingListService.shippingPageCalc(page));


        return "userpage/u_shippingList";
    }

    @GetMapping("/u_shippingRequest")
    public String getUshippingRequest() {
        return "userpage/u_shippingRequest";
    }
}
