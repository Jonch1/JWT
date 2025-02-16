package com.example.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class JWTService {

    private final String SECRET_KEY = "JcP7cBErkaeXJTVhrps4uDhd768Hmak0qQ9GeJR7espsH5S1MhK29r10RmeydZPD"; // Debe tener al menos 32 caracteres

    @PostMapping("/generateToken")
    public String generateToken(@RequestParam String username) {
        return Jwts.builder()
                .setSubject(username)  // Asignar el usuario al token
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // Firma con clave secreta
                .compact();  // Genera el token
    }
}