package com.cultodeportivo.backend.services.imp;

import com.cultodeportivo.backend.models.Posicion;
import com.cultodeportivo.backend.repositories.PosicionRepository;
import com.cultodeportivo.backend.services.PosicionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PosicionServiceImp implements PosicionService {

    private final PosicionRepository posicionRepository;

    public PosicionServiceImp(PosicionRepository posicionRepository) {
        this.posicionRepository = posicionRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Posicion> findAll() {
        return posicionRepository.findAll();
    }

    @Transactional
    @Override
    public Posicion save(Posicion posicion) {
        return posicionRepository.save(posicion);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Posicion> findById(Long id) {
        return posicionRepository.findById(id);
    }
}
