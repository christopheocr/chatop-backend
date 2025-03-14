package com.chatop.backend.controller;


import com.chatop.backend.dto.LoginResponseDto;
import com.chatop.backend.dto.LoginUserDto;
import com.chatop.backend.dto.RegisterUserDto;
import com.chatop.backend.dto.UserInfoDto;
import com.chatop.backend.entity.User;
import com.chatop.backend.service.AuthenticationService;
import com.chatop.backend.service.JwtService;
import com.chatop.backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Authentification", description = "Endpoints permettant l'inscription, la connexion et la récupération des informations de l'utilisateur connecté.")
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

    @Operation(summary = "Enregistrer un nouvel utilisateur", description = "Permet à un utilisateur de créer un compte.")
    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);
        if (registeredUser == null || registeredUser.getId() == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Authentifier un utilisateur", description = "Permet à un utilisateur de se connecter et de recevoir un token JWT.")
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponseDto loginResponse = new LoginResponseDto();
        loginResponse.setToken(jwtToken);
        return ResponseEntity.ok(loginResponse);
    }

    @Operation(summary = "Récupérer les informations de l'utilisateur connecté",
            description = "Retourne les informations de l'utilisateur actuellement authentifié. Nécessite un JWT.")
    @SecurityRequirement(name = "BearerAuth")
    @GetMapping("/me")
    public ResponseEntity<UserInfoDto> authenticatedUser() {
        User currentUser = userService.getCurrentUser();
        UserInfoDto userDto = userService.convertToUserInfoDto(currentUser);
        return ResponseEntity.ok(userDto);
    }
}
