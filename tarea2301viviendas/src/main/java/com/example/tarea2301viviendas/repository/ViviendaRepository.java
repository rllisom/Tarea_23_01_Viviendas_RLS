package com.example.tarea2301viviendas.repository;

import com.example.tarea2301viviendas.model.Vivienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ViviendaRepository  extends JpaRepository<Vivienda,Long>, JpaSpecificationExecutor<Vivienda> {
}
