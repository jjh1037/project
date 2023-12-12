package com.example.adminPage.controller;

import com.example.adminPage.dto.RequestDto;
import com.example.adminPage.mappers.UserShippingMapper;
import com.example.adminPage.service.UserShippingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserShippingController {

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
                                   @RequestParam(value ="page", defaultValue = "1") int page) {

        model.addAttribute("cnt", userShippingListService.getSearchCnt(searchType, words));
        model.addAttribute("list", userShippingListService.getSearch(page, searchType, words));
        model.addAttribute("page", userShippingListService.shippingPageCalc(page));


        return "userpage/u_shippingList";
    }

    @GetMapping("/u_shippingRequest")
    public String getUshippingRequest(@RequestParam int id, Model model) {

        model.addAttribute("view", userShippingMapper.getView(id));

        return "userpage/u_shippingRequest";
    }

    @PostMapping("/u_shippingRequest")
    public String setUshippingRequest(@ModelAttribute RequestDto requestDto) {

        userShippingMapper.setRequest(requestDto);
        return "redirect:/user/u_shippingList";
    }


}
