package com.example.tarea2301viviendas.dto;

import com.example.tarea2301viviendas.model.EstadoVivienda;
import com.example.tarea2301viviendas.model.TipoVivienda;

public record ParametrosDto(
        String ciudad, String provincia, Double precioMin, Double precioMax,
        Double metrosMin, Double metrosMax, Integer habMin, Integer banosMin,
        TipoVivienda tipo, EstadoVivienda estado, Boolean ascensor,
        Boolean terraza, Boolean garaje, Boolean disponible
) {
}
