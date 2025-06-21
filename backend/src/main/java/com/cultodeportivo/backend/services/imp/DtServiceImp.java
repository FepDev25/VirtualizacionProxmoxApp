package com.cultodeportivo.backend.services.imp;

import com.cultodeportivo.backend.dto.DtDTO;
import com.cultodeportivo.backend.models.Dt;
import com.cultodeportivo.backend.repositories.DtReposiroty;
import com.cultodeportivo.backend.repositories.EquipoRepository;
import com.cultodeportivo.backend.repositories.PaisRepository;
import com.cultodeportivo.backend.services.DtService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DtServiceImp implements DtService {

    private final DtReposiroty dtReposiroty;
    private final EquipoRepository equipoRepository;
    private final PaisRepository paisRepository;

    public DtServiceImp(DtReposiroty dtReposiroty, EquipoRepository equipoRepository, PaisRepository paisRepository) {
        this.dtReposiroty = dtReposiroty;
        this.equipoRepository = equipoRepository;
        this.paisRepository = paisRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Dt> findAll() {
        return dtReposiroty.findAll();
    }

    @Transactional
    @Override
    public Dt save(DtDTO dtDTO) {
        Dt dt = new Dt();
        dt.setNombre(dtDTO.getNombre());
        dt.setPais(paisRepository.findById(dtDTO.getPaisId()).orElseThrow());
        dt.setEquipo(equipoRepository.findById(dtDTO.getEquipoId()).orElseThrow());
        return dtReposiroty.save(dt);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Dt> findById(Long id) {
        return dtReposiroty.findById(id);
    }

    @Transactional
    @Override
    public Optional<Dt> update(Long id, DtDTO dt) {
        Optional<Dt> dtOptional = findById(id);
        if (dtOptional.isPresent()) {
            Dt dtUpdate = dtOptional.get();
            dtUpdate.setId(id);
            dtUpdate.setNombre(dt.getNombre());
            dtUpdate.setPais(paisRepository.findById(dt.getPaisId()).orElseThrow());
            dtUpdate.setEquipo(equipoRepository.findById(dt.getEquipoId()).orElseThrow());

            Dt save = dtReposiroty.save(dtUpdate);
            return Optional.of(save);
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Optional<Dt> dt = findById(id);
        if (dt.isPresent()) {
            dtReposiroty.deleteById(id);
        }
    }
}
