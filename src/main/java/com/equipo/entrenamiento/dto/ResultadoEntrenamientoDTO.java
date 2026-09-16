package com.equipo.entrenamiento.dto;

public class ResultadoEntrenamientoDTO {

    private String jugador;
    private double potenciaTiro;
    private double velocidad;
    private int pases;

    public ResultadoEntrenamientoDTO() {
    }

    public ResultadoEntrenamientoDTO(String jugador, double potenciaTiro, double velocidad, int pases) {
        this.jugador = jugador;
        this.potenciaTiro = potenciaTiro;
        this.velocidad = velocidad;
        this.pases = pases;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public double getPotenciaTiro() {
        return potenciaTiro;
    }

    public void setPotenciaTiro(double potenciaTiro) {
        this.potenciaTiro = potenciaTiro;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public int getPases() {
        return pases;
    }

    public void setPases(int pases) {
        this.pases = pases;
    }
}