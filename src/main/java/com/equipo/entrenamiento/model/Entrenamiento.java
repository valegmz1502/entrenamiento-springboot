package com.equipo.entrenamiento.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Entrenamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;

    @OneToMany(mappedBy = "entrenamiento", cascade = CascadeType.ALL)
private List<ResultadoEntrenamiento> resultados = new ArrayList<>();

    public Entrenamiento() {
    }

    public Entrenamiento(int numero) {
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<ResultadoEntrenamiento> getResultados() {
        return resultados;
    }

    public void setResultados(List<ResultadoEntrenamiento> resultados) {
        this.resultados = resultados;
    }
}