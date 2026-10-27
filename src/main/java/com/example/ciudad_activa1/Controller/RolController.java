package com.example.ciudad_activa1.Controller;

import com.example.ciudad_activa1.Entity.Rol;
import com.example.ciudad_activa1.Service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @PostMapping
    public ResponseEntity<Rol> crearRol(@RequestBody Rol rol){
        Rol nuevoRol = rolService.crearRol(rol);
        return new ResponseEntity<>(nuevoRol, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Rol>> listarRoles(){
        List<Rol> roles = rolService.listarRoles();
        return ResponseEntity.ok(roles);
    }
}
