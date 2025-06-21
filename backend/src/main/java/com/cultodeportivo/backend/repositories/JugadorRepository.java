package com.cultodeportivo.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cultodeportivo.backend.models.Jugador;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {
    
}
