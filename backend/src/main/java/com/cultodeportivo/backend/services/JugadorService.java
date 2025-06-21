package com.cultodeportivo.backend.services;

import com.cultodeportivo.backend.dto.JugadorDTO;
import com.cultodeportivo.backend.models.Jugador;
import java.util.List;
import java.util.Optional;

public interface JugadorService {

    List<Jugador> findAll();
    Jugador save(JugadorDTO jugadorDTO);
    Optional<Jugador> findById(Long id);
    Optional<Jugador> update(Long id, JugadorDTO jugadorDTO);
    void delete(Long id);

}
