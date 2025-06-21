package com.cultodeportivo.backend.controllers;

import com.cultodeportivo.backend.dto.JugadorDTO;
import com.cultodeportivo.backend.models.Jugador;
import com.cultodeportivo.backend.services.JugadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    private final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @GetMapping
    public List<Jugador> getJugadores() {
        return this.jugadorService.findAll();
    }

    @GetMapping("/{id}")
    public Jugador getJugadorById(@PathVariable Long id) {
        return this.jugadorService.findById(id).orElse(null);
    }

    @PostMapping
    public Jugador saveJugador(@RequestBody JugadorDTO jugador) {
        return this.jugadorService.save(jugador);
    }

    @PutMapping("/{id}")
    public Jugador updateJugador(@RequestBody JugadorDTO jugador, @PathVariable Long id) {
        return this.jugadorService.update(id, jugador).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteJugador(@PathVariable Long id) {
        this.jugadorService.delete(id);
    }


}
