package com.equipo.entrenamiento.repository;

import com.equipo.entrenamiento.model.Entrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrenamientoRepository extends JpaRepository<Entrenamiento, Long> {
}