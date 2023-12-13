package com.dt.copeland.controller;

import com.dt.copeland.dto.LoginDTO;
import com.dt.copeland.dto.RegisterDTO;
import com.dt.copeland.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(AuthenticationController.PATH)
public class AuthenticationController {
    public static final String PATH = "/api/v1/auth";

    private AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO) {
        String response = authenticationService.register(registerDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody LoginDTO loginDTO) {
         Boolean response = authenticationService.login(loginDTO);
         return ResponseEntity.ok(response);
    }
}
