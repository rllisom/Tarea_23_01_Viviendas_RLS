package com.example.tarea2301viviendas.dto;

import com.example.tarea2301viviendas.model.EstadoVivienda;
import com.example.tarea2301viviendas.model.TipoVivienda;
import com.example.tarea2301viviendas.validation.MetrosCuadradosFueraDeRango;
import com.example.tarea2301viviendas.validation.PrecioFueraDeRango;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ViviendaCreateRequest(
        @NotBlank(message = "{vivendaCreateRequest.titulo.notblank}") @Size(max = 120)
        String titulo,
        @Size(max = 2000)
        String descripcion,
        @NotBlank @Size(max = 80)
        String ciudad,
        @NotBlank @Size(max = 80)
        String provincia,
        @NotNull @Min(0) @PrecioFueraDeRango(precioMax = 1_000_000)
        int precio,
        @Min(1) @MetrosCuadradosFueraDeRango(metrosCuadradosMax = 1_000)
        int metrosCuadrados,
        @NotNull @Min(0)
        int habitaciones,
        @NotNull @Min(0)
        int banos,
        @NotNull
        TipoVivienda tipo,
        @NotNull
        EstadoVivienda estado,
        @NotNull
        boolean ascensor,
        @NotNull
        boolean terraza,
        @NotNull
        boolean garaje,
        @NotNull
        boolean disponible
) {
}
