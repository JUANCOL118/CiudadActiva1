package com.example.ciudad_activa1.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("correo");
        String password = loginRequest.get("contraseña");

        // TODO: Integrar aquí con tu AuthenticationManager de Spring Security o tu Repositorio
        // Por ahora devolvemos una respuesta JSON bien estructurada con valores ASCII limpios

        if (email == null || email.isBlank()) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "El correo es requerido");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }

        Map<String, Object> response = new HashMap<>();
        // El token DEBE ser una cadena alfanumérica pura (JWT hash real o simulado ASCII)
        response.put("token", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c3VhcmlvIn0.sample_jwt_token_ascii");
        response.put("nombre", "Diego");
        response.put("apellido", "Cifuentes");
        response.put("email", email);

        // Asignar el rol basado en el dominio si deseas probar lógica de negocio
        if (email.endsWith("@gestor.com")) {
            response.put("rol", "GESTOR");
        } else if (email.endsWith("@operador.com")) {
            response.put("rol", "OPERADOR");
        } else if (email.endsWith("@admin.com")) {
            response.put("rol", "ADMINISTRADOR");
        } else {
            response.put("rol", "CIUDADANO");
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, Object> registerRequest) {
        // TODO: Guardar el nuevo usuario en la base de datos (PostgreSQL/Supabase)

        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "Usuario registrado correctamente");
        return ResponseEntity.ok(response);
    }
}