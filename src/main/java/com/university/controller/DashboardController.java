//package com.university.controller;
//
//import com.university.model.User;
//import com.university.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.time.LocalDate;
//import java.util.stream.Collectors;
//
//@Controller
//public class DashboardController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/dashboard")
//    public String showDashboard(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
//
//        // Get user details from database
//        User user = userService.findByUsername(username);
//
//        // Add user information to model
//        model.addAttribute("username", username);
//        model.addAttribute("roles", user.getRoles().stream()
//                .map(role -> role.replace("ROLE_", ""))
//                .collect(Collectors.joining(", ")));
//        model.addAttribute("registrationDate", user.getCreatedAt());
//        model.addAttribute("currentDate", LocalDate.now());
//
//        // Add role-specific flags
//        model.addAttribute("isAdmin", user.getRoles().contains("ADMIN"));
//        model.addAttribute("isStudent", user.getRoles().contains("STUDENT"));
//        model.addAttribute("isAlumni", user.getRoles().contains("ALUMNI"));
//
//        return "dashboard";
//    }
//}