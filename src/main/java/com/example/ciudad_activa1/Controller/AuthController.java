package com.example.ciudad_activa1.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Object loginRequest) {
        // Aquí conectaremos la validación de credenciales o el servicio de seguridad
        return ResponseEntity.ok("Autenticación en proceso - Endpoint activo");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Object registerRequest) {
        // Opcional por si deseas permitir registro desde la API
        return ResponseEntity.ok("Registro de usuario recibido");
    }
}

