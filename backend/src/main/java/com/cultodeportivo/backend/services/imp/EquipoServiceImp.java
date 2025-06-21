package com.cultodeportivo.backend.services.imp;

import com.cultodeportivo.backend.models.Equipo;
import com.cultodeportivo.backend.repositories.EquipoRepository;
import com.cultodeportivo.backend.services.EquipoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoServiceImp implements EquipoService {

    private final EquipoRepository equipoRepository;

    public EquipoServiceImp(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Equipo> findAll() {
        return equipoRepository.findAll();
    }

    @Transactional
    @Override
    public Equipo save(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Equipo> findById(Long id) {
        return equipoRepository.findById(id);
    }

    @Transactional
    @Override
    public Optional<Equipo> update(Long id, Equipo equipo) {
        Optional<Equipo> equipoUpdate = findById(id);
        if (equipoUpdate.isPresent()) {
            equipo.setId(id);
            return Optional.of(save(equipo));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Optional<Equipo> equipo = findById(id);
        if (equipo.isPresent()) {
            equipoRepository.deleteById(id);
        }
    }
}
