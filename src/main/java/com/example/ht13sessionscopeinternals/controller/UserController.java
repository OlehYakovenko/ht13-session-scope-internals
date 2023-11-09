package com.example.ht13sessionscopeinternals.controller;

import com.example.ht13sessionscopeinternals.dto.User;
import com.example.ht13sessionscopeinternals.service.SecurityContextServiceProxy;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final SecurityContextServiceProxy service;

    public UserController(SecurityContextServiceProxy service) {
        this.service = service;
    }

    @PostMapping("/signin")
    public void setUser(@RequestBody User user){
        service.setCurrentUser(user);
    }
    @GetMapping("/current")
    public User getCurrentUser(){
        return service.getCurrentUser();
    }
}
