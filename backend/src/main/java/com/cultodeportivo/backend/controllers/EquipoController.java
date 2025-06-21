package com.cultodeportivo.backend.controllers;

import com.cultodeportivo.backend.models.Equipo;
import com.cultodeportivo.backend.services.EquipoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping
    public List<Equipo> getEquipos() {
        return this.equipoService.findAll();
    }

    @PostMapping
    public Equipo createEquipo(@RequestBody Equipo equipo) {
        return this.equipoService.save(equipo);
    }

    @PutMapping("/{id}")
    public Equipo updateEquipo(@RequestBody Equipo equipo, @PathVariable Long id) {
        return this.equipoService.update(id, equipo).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipo(@PathVariable Long id) {
        this.equipoService.delete(id);
    }
}
