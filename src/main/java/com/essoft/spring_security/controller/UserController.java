package com.essoft.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/index")
    public String index(){
        return "welcome to index page";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "welcome to dashboard page";
    }
}
