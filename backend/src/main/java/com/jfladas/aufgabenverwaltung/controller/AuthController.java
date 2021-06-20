package com.example.aufgabenverwaltung.controller;

import com.example.aufgabenverwaltung.auth.PgAuthenticationProvider;
import com.example.aufgabenverwaltung.dto.UserDto;
import com.example.aufgabenverwaltung.model.User;
import com.example.aufgabenverwaltung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    private final UserService userService;
    private final PgAuthenticationProvider authenticationProvider;

    @Autowired
    public AuthController(UserService userService, PgAuthenticationProvider authenticationProvider) {
        this.userService = userService;
        this.authenticationProvider = authenticationProvider;
    }

    @PostMapping("/register")
    public User register(@RequestBody final User user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public void login(@RequestBody final UserDto loginRequest){
        final Authentication authentication = authenticationProvider.login(loginRequest);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }


    @GetMapping("/info")
    public Authentication getInfo() {
        final SecurityContext context = SecurityContextHolder.getContext();
        return context.getAuthentication();
    }
}