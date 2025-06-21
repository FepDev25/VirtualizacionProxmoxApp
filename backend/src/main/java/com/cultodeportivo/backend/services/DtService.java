package com.cultodeportivo.backend.services;

import com.cultodeportivo.backend.dto.DtDTO;
import com.cultodeportivo.backend.models.Dt;

import java.util.List;
import java.util.Optional;

public interface DtService {
    List<Dt> findAll();
    Dt save(DtDTO dt);
    Optional<Dt> findById(Long id);
    Optional<Dt> update(Long id, DtDTO dt);
    void delete(Long id);
}
