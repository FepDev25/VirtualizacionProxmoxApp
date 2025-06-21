package com.cultodeportivo.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cultodeportivo.backend.models.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    
}
