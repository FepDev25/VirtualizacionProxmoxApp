package com.cultodeportivo.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cultodeportivo.backend.models.Pais;
import com.cultodeportivo.backend.services.PaisService;


@RestController
@RequestMapping("/api/paises")
public class PaisController {

    private final PaisService paisService;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @GetMapping()
    public List<Pais> getPais() {
        return this.paisService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPaisById( @PathVariable Long id) {
        Optional<Pais> pais = this.paisService.findById(id);
        return pais.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public Pais createPais(@RequestBody Pais pais) {
        return this.paisService.save(pais);
    }

    
    
}
