package com.anymind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class MainPageController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String vetList(Model model) {
        return "index";
    }
}
