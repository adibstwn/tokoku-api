package com.tokoku.controllers;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * WelcomeController
 */
@RestController
@RequestMapping("/api/welcome")
public class WelcomeController {
    @GetMapping // handle get method
    public String welcom() {
        return "Welcome to Spring booot";
    }

}