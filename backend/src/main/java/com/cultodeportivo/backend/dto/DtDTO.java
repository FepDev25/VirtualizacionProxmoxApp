package com.cultodeportivo.backend.dto;

public class DtDTO {

    private Long id;
    private String nombre;
    private Long paisId;
    private Long equipoId;

    public DtDTO() {}

    public DtDTO(Long id, String nombre, Long paisId, Long equipoId) {
        this.id = id;
        this.nombre = nombre;
        this.paisId = paisId;
        this.equipoId = equipoId;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPaisId() {
        return paisId;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }

    public Long getEquipoId() {
        return equipoId;
    }

    public void setEquipoId(Long equipoId) {
        this.equipoId = equipoId;
    }
}
