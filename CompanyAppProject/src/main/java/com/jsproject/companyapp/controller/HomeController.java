package com.jsproject.companyapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {


    @RequestMapping("/api/home")
    public String index() {
        return "home.html";
    }
}
