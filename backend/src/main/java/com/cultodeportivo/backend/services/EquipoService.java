package com.cultodeportivo.backend.services;


import com.cultodeportivo.backend.models.Equipo;

import java.util.List;
import java.util.Optional;

public interface EquipoService {

    List<Equipo> findAll();
    Equipo save(Equipo equipo);
    Optional<Equipo> findById(Long id);
    Optional<Equipo> update(Long id, Equipo equipo);
    void delete(Long id);

    
}
