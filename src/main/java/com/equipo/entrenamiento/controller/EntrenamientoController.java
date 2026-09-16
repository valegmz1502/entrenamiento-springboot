package com.equipo.entrenamiento.controller;

import com.equipo.entrenamiento.model.Entrenamiento;
import com.equipo.entrenamiento.dto.JugadorTitularDTO;
import com.equipo.entrenamiento.service.EntrenamientoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrenamientos")
public class EntrenamientoController {

    private final EntrenamientoService service;

    public EntrenamientoController(EntrenamientoService service) {
        this.service = service;
    }

    @PostMapping
    public String guardarEntrenamiento(@RequestBody Entrenamiento entrenamiento) {

        service.guardarEntrenamiento(entrenamiento);

        return "Entrenamiento guardado correctamente";
    }

    @GetMapping
    public List<Entrenamiento> obtenerEntrenamientos() {

        return service.obtenerEntrenamientos();
    }

    @GetMapping("/titulares")
public Object obtenerTitulares() {

    List<JugadorTitularDTO> titulares = service.obtenerTitulares();

    if (titulares.isEmpty()) {
        return "Información insuficiente. Se necesitan los 3 entrenamientos.";
    }

    return titulares;
}
}