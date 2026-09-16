package com.equipo.entrenamiento.repository;

import com.equipo.entrenamiento.model.ResultadoEntrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultadoEntrenamientoRepository extends JpaRepository<ResultadoEntrenamiento, Long> {
}