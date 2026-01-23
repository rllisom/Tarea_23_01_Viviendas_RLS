package com.example.tarea2301viviendas.service;

import com.example.tarea2301viviendas.dto.ParametrosDto;
import com.example.tarea2301viviendas.dto.ViviendaResponse;
import com.example.tarea2301viviendas.filter.ViviendaSpec;
import com.example.tarea2301viviendas.model.EstadoVivienda;
import com.example.tarea2301viviendas.model.TipoVivienda;
import com.example.tarea2301viviendas.model.Vivienda;
import com.example.tarea2301viviendas.repository.ViviendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ViviendaService {

    private final ViviendaRepository viviendaRepository;

    public Page<Vivienda> devolverFiltrado(ParametrosDto param, Pageable pageable){
        return viviendaRepository.findBy(
                PredicateSpecification.allOf(
                        ViviendaSpec.filtrarPorCiudad(param.ciudad()),
                        ViviendaSpec.filtrarPorProvincia(param.provincia()),
                        ViviendaSpec.filtrarPorPrecio(param.precioMin(),param.precioMax()),
                        ViviendaSpec.filtrarPorMetros(param.metrosMin(), param.metrosMax()),
                        ViviendaSpec.filtrarPorNumHabitaciones(param.habMin()),
                        ViviendaSpec.filtrarPorNumBanios(param.banosMin()),
                        ViviendaSpec.filtrarPorAscensor(),
                        ViviendaSpec.filtrarPorTerraza(),
                        ViviendaSpec.filtrarPorGaraje(),
                        ViviendaSpec.filtrarPorDisponibilidad(param.disponible())
                ), q -> q.page(pageable)
        );
    }
}
