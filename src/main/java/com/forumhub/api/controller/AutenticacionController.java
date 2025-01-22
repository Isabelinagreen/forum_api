package com.forumhub.api.controller;

import com.forumhub.api.model.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AutenticacionController {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AutenticacionController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Autenticación del usuario
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );

            // Guardar el contexto de autenticación
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Respuesta exitosa
            return ResponseEntity.ok("Autenticación exitosa");
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Autenticación fallida: " + e.getMessage());
        }
    }
}
