package com.cultodeportivo.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cultodeportivo.backend.models.Posicion;

public interface PosicionRepository extends JpaRepository<Posicion, Long> {
    
}
