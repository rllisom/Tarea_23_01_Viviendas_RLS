package com.example.tarea2301viviendas.dto;

import com.example.tarea2301viviendas.model.EstadoVivienda;
import com.example.tarea2301viviendas.model.TipoVivienda;

import java.time.LocalDate;

public record ViviendaResponse(
        Long id, String titulo, String ciudad, String provincia, String precio, String metrosCuadrados,
        int habitaciones, int banos, TipoVivienda tipoVivienda, EstadoVivienda estado, boolean disponibilidad,
        LocalDate fechaPublicacion
        ) {
}
