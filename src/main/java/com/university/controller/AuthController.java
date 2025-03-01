package com.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Renders login.html
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login?logout"; // Redirects to login page with logout message
    }
}