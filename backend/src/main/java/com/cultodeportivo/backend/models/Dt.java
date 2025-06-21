package com.cultodeportivo.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "dt")
public class Dt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;
    
    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    public Dt() {}

    public Dt(Long id, String nombre, Pais pais, Equipo equipo) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.equipo = equipo;
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

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    
    
}
