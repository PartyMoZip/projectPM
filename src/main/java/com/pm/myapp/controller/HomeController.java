package com.pm.myapp.controller;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@NoArgsConstructor

@Controller
public class HomeController {

    // 메인 페이지
    @GetMapping("/")
    public String home() {

        return "index";
    }

}
