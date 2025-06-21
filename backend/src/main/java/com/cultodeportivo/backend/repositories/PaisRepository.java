package com.cultodeportivo.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cultodeportivo.backend.models.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {
    
}
