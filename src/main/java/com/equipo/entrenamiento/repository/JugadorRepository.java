package com.equipo.entrenamiento.repository;

import com.equipo.entrenamiento.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    Optional<Jugador> findByNombre(String nombre);
}