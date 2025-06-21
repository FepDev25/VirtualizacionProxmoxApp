package com.cultodeportivo.backend.services;

import java.util.List;
import java.util.Optional;

import com.cultodeportivo.backend.models.Pais;

public interface PaisService {

    List<Pais> findAll();
    Pais save(Pais pais);
    Optional<Pais> findById(Long id);

}
