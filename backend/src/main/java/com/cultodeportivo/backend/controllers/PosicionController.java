package com.cultodeportivo.backend.controllers;

import com.cultodeportivo.backend.models.Posicion;
import com.cultodeportivo.backend.services.PosicionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posiciones")
public class PosicionController {

    private final PosicionService posicionService;

    public PosicionController(PosicionService posicionService) {
        this.posicionService = posicionService;
    }

    @GetMapping()
    public List<Posicion> getPosiciones() {
        return this.posicionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Posicion> getPosicionById(@PathVariable Long id) {
        return ResponseEntity.ok(this.posicionService.findById(id).orElse(null));
    }

    @PostMapping
    public Posicion createPosicion(@RequestBody Posicion posicion) {
        return this.posicionService.save(posicion);
    }
}
