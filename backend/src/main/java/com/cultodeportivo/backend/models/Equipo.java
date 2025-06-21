package com.cultodeportivo.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "equipo")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String ciudad;
    @Column(name = "anio_fundacion")
    private Integer fundacion;

    public Equipo() {}

    public Equipo(Long id, String nombre, String ciudad, Integer fundacion) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fundacion = fundacion;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getFundacion() {
        return fundacion;
    }

    public void setFundacion(Integer fundacion) {
        this.fundacion = fundacion;
    }

    
    
}
