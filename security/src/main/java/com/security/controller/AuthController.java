package com.security.controller;

import com.security.model.AuthenticationResponce;
import com.security.model.User;
import com.security.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponce> register(@RequestBody User user){
        return ResponseEntity.ok(authService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponce> authenticate(@RequestBody User user) {
        return ResponseEntity.ok(authService.authenticate(user));
    }
}
