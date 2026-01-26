package com.example.tarea2301viviendas.dto;

import com.example.tarea2301viviendas.model.EstadoVivienda;
import com.example.tarea2301viviendas.model.TipoVivienda;
import com.example.tarea2301viviendas.model.Vivienda;

import java.time.LocalDate;

public record ViviendaResponse(
        Long id, String titulo, String ciudad, String provincia, Double precio, Double metrosCuadrados,
        int habitaciones, int banos, TipoVivienda tipoVivienda, EstadoVivienda estado, boolean disponibilidad,
        LocalDate fechaPublicacion
        ) {

        public static ViviendaResponse of(Vivienda v){
                return new ViviendaResponse(
                        v.getId(),
                        v.getTitulo(),
                        v.getCiudad(),
                        v.getProvincia(),
                        v.getPrecio(),
                        v.getMetrosCuadrados(),
                        v.getHabitaciones(),
                        v.getBanos(),
                        v.getTipoVivienda(),
                        v.getEstado(),
                        v.isDisponible(),
                        v.getFechaPublicacion()
                );
        }
}
