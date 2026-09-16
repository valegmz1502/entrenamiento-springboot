package com.equipo.entrenamiento.service;

import com.equipo.entrenamiento.model.Entrenamiento;
import com.equipo.entrenamiento.model.Jugador;
import com.equipo.entrenamiento.model.ResultadoEntrenamiento;
import com.equipo.entrenamiento.repository.EntrenamientoRepository;
import com.equipo.entrenamiento.repository.JugadorRepository;
import com.equipo.entrenamiento.repository.ResultadoEntrenamientoRepository;
import com.equipo.entrenamiento.dto.JugadorTitularDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class EntrenamientoService {

    private final EntrenamientoRepository entrenamientoRepository;
    private final JugadorRepository jugadorRepository;
    private final ResultadoEntrenamientoRepository resultadoRepository;

    public EntrenamientoService(
            EntrenamientoRepository entrenamientoRepository,
            JugadorRepository jugadorRepository,
            ResultadoEntrenamientoRepository resultadoRepository) {

        this.entrenamientoRepository = entrenamientoRepository;
        this.jugadorRepository = jugadorRepository;
        this.resultadoRepository = resultadoRepository;
    }

public void guardarEntrenamiento(Entrenamiento entrenamiento) {

    for (ResultadoEntrenamiento resultado : entrenamiento.getResultados()) {

        double puntuacion =
                (resultado.getPotenciaTiro() * 0.20)
                + (resultado.getVelocidad() * 0.30)
                + (resultado.getPases() * 0.50);

        resultado.setResultado(puntuacion);

        Jugador jugador = jugadorRepository
                .findByNombre(resultado.getNombreJugador())
                .orElseGet(() -> {
                    Jugador nuevoJugador =
                            new Jugador(resultado.getNombreJugador());

                    return jugadorRepository.save(nuevoJugador);
                });

        resultado.setJugador(jugador);
    }

    entrenamientoRepository.save(entrenamiento);
}
    
    public List<Entrenamiento> obtenerEntrenamientos() {

        return entrenamientoRepository.findAll();
    }

    public List<JugadorTitularDTO> obtenerTitulares() {

        List<ResultadoEntrenamiento> resultados =
                resultadoRepository.findAll();

        if (resultados.size() < 21) {
            return new ArrayList<>();
        }

        List<JugadorTitularDTO> titulares = new ArrayList<>();

        for (int i = 0; i < 7; i++) {

            double suma = 0;

            for (ResultadoEntrenamiento resultado : resultados) {

                if (resultado.getJugador().getNombre()
                        .equals("Jugador" + (i + 1))) {

                    suma += resultado.getResultado();
                }
            }

            double promedio = Math.round((suma / 3) * 100.0) / 100.0;

            titulares.add(
                    new JugadorTitularDTO(
                            "Jugador" + (i + 1),
                            promedio
                    )
            );
        }

        titulares.sort(
                Comparator.comparingDouble(
                        JugadorTitularDTO::getPuntuacion
                ).reversed()
        );

        return titulares.subList(0, 5);
    }
}