package com.university.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping
    @PreAuthorize("hasRole('STUDENT')")
    public String studentDashboard() {
        return "Welcome, Student!";
    }
}

