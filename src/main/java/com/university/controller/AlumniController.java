package com.university.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumni")
public class AlumniController {

    @GetMapping
    @PreAuthorize("hasRole('ALUMNI')")
    public String alumniDashboard() {
        return "Welcome, Alumni!";
    }
}
