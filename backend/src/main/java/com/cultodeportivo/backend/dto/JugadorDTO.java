package com.cultodeportivo.backend.dto;

public class JugadorDTO {

    private Long id;
    private String nombre;
    private Integer edad;
    private Long paisId;
    private Long equipoId;
    private Long posicionId;

    public JugadorDTO() {}

    public JugadorDTO(Long id, String nombre, Integer edad, Long paisId, Long equipoId, Long posicionId) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.paisId = paisId;
        this.equipoId = equipoId;
        this.posicionId = posicionId;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
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

    public Long getPosicionId() {
        return posicionId;
    }

    public void setPosicionId(Long posicionId) {
        this.posicionId = posicionId;
    }
}

