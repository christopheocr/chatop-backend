package com.chatop.backend.controller;


import com.chatop.backend.dto.LoginResponseDto;
import com.chatop.backend.dto.LoginUserDto;
import com.chatop.backend.dto.RegisterUserDto;
import com.chatop.backend.dto.UserInfoDto;
import com.chatop.backend.entity.User;
import com.chatop.backend.service.AuthenticationService;
import com.chatop.backend.service.JwtService;
import com.chatop.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    private final UserService userService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService, UserService userService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);
        if (registeredUser == null || registeredUser.getId() == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponseDto loginResponse = new LoginResponseDto();
        loginResponse.setToken(jwtToken);
        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("/me")
    public ResponseEntity<UserInfoDto> authenticatedUser() {
        User currentUser = userService.getCurrentUser();
        UserInfoDto userDto = userService.convertToUserInfoDto(currentUser);
        return ResponseEntity.ok(userDto);
    }
}
