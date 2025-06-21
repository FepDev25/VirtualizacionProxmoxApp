package com.cultodeportivo.backend.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cultodeportivo.backend.models.Pais;
import com.cultodeportivo.backend.repositories.PaisRepository;
import com.cultodeportivo.backend.services.PaisService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaisServiceImp implements PaisService {

    private final PaisRepository paisRepository;

    public PaisServiceImp(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Pais> findAll() {
        return paisRepository.findAll();
    }

    @Transactional
    @Override
    public Pais save(Pais pais) {
        return paisRepository.save(pais);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Pais> findById(Long id) {
        return paisRepository.findById(id);
    }
    
}
