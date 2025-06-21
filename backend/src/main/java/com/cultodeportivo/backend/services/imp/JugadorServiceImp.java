package com.cultodeportivo.backend.services.imp;

import com.cultodeportivo.backend.dto.JugadorDTO;
import com.cultodeportivo.backend.models.Jugador;
import com.cultodeportivo.backend.repositories.EquipoRepository;
import com.cultodeportivo.backend.repositories.JugadorRepository;
import com.cultodeportivo.backend.repositories.PaisRepository;
import com.cultodeportivo.backend.repositories.PosicionRepository;
import com.cultodeportivo.backend.services.JugadorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorServiceImp implements JugadorService {

    private final JugadorRepository jugadorRepository;
    private final EquipoRepository equipoRepository;
    private final PaisRepository paisRepository;
    private final PosicionRepository posicionRepository;

    public JugadorServiceImp(JugadorRepository jugadorRepository, EquipoRepository equipoRepository, PaisRepository paisRepository, PosicionRepository posicionRepository) {
        this.jugadorRepository = jugadorRepository;
        this.equipoRepository = equipoRepository;
        this.paisRepository = paisRepository;
        this.posicionRepository = posicionRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Jugador> findAll() {
        return jugadorRepository.findAll();
    }

    @Transactional
    @Override
    public Jugador save(JugadorDTO jugadorDTO) {
        Jugador jugador = new Jugador();
        jugador.setNombre(jugadorDTO.getNombre());
        jugador.setEdad(jugadorDTO.getEdad());
        jugador.setPais(paisRepository.findById(jugadorDTO.getPaisId()).orElseThrow());
        jugador.setEquipo(equipoRepository.findById(jugadorDTO.getEquipoId()).orElseThrow());
        jugador.setPosicion(posicionRepository.findById(jugadorDTO.getPosicionId()).orElseThrow());
        return jugadorRepository.save(jugador);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Jugador> findById(Long id) {
        return jugadorRepository.findById(id);
    }

    @Transactional
    @Override
    public Optional<Jugador> update(Long id, JugadorDTO jugadorDTO) {
        Optional<Jugador> jugadorUpdate = findById(id);
        if (jugadorUpdate.isPresent()) {
            Jugador jugador = jugadorUpdate.get();
            jugador.setId(id);
            jugador.setNombre(jugadorDTO.getNombre());
            jugador.setEdad(jugadorDTO.getEdad());
            jugador.setPais(paisRepository.findById(jugadorDTO.getPaisId()).orElseThrow());
            jugador.setEquipo(equipoRepository.findById(jugadorDTO.getEquipoId()).orElseThrow());
            jugador.setPosicion(posicionRepository.findById(jugadorDTO.getPosicionId()).orElseThrow());

            Jugador save = jugadorRepository.save(jugador);
            return Optional.of(save);
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Optional<Jugador> jugador = findById(id);
        if (jugador.isPresent()) {
            jugadorRepository.deleteById(id);
        }
    }
}
