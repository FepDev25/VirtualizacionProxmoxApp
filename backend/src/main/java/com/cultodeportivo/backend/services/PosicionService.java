package com.cultodeportivo.backend.services;

import com.cultodeportivo.backend.models.Posicion;

import java.util.List;
import java.util.Optional;

public interface PosicionService {

    List<Posicion> findAll();
    Posicion save(Posicion posicion);
    Optional<Posicion> findById(Long id);
}
