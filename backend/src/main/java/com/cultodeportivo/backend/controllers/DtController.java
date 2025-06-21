package com.cultodeportivo.backend.controllers;

import com.cultodeportivo.backend.dto.DtDTO;
import com.cultodeportivo.backend.models.Dt;
import com.cultodeportivo.backend.services.DtService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dts")
public class DtController {

    private final DtService dtService;

    public DtController(DtService dtService) {
        this.dtService = dtService;
    }

    @GetMapping
    public List<Dt> getDts() {
        return dtService.findAll();
    }

    @GetMapping("/{id}")
    public Dt getDtById(@PathVariable Long id) {
        return dtService.findById(id).orElse(null);
    }

    @PostMapping
    public Dt saveDt(@RequestBody DtDTO dtDTO) {
        return dtService.save(dtDTO);
    }

    @PutMapping("/{id}")
    public Dt updateDt(@RequestBody DtDTO dtDTO, @PathVariable Long id) {
        return dtService.update(id, dtDTO).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteDt(@PathVariable Long id) {
        dtService.delete(id);
    }

}
