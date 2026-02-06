package com.example.tarea2301viviendas.controller;

import com.example.tarea2301viviendas.dto.ParametrosDto;
import com.example.tarea2301viviendas.dto.ViviendaCreateRequest;
import com.example.tarea2301viviendas.dto.ViviendaResponse;
import com.example.tarea2301viviendas.model.EstadoVivienda;
import com.example.tarea2301viviendas.model.TipoVivienda;
import com.example.tarea2301viviendas.service.ViviendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("api/v1/viviendas")
@RestController
public class ViviendaController {

    private final ViviendaService viviendaService;

    @GetMapping
    public Page<ViviendaResponse> filtrarBusqueda(@PageableDefault(page = 0,size = 20,sort = "ciudad", direction = Sort.Direction.DESC) Pageable pageable,
                                                  @RequestParam(required = false) String ciudad,
                                                  @RequestParam(required = false) String provincia,
                                                  @RequestParam(required = false) Double precioMin,
                                                  @RequestParam(required = false) Double precioMax,
                                                  @RequestParam(required = false) Double metrosMin,
                                                  @RequestParam(required = false) Double metrosMax,
                                                  @RequestParam(required = false) Integer habMin,
                                                  @RequestParam(required = false) Integer banosMin,
                                                  @RequestParam(required = false) TipoVivienda tipo,
                                                  @RequestParam(required = false) EstadoVivienda estado,
                                                  @RequestParam(required = false) Boolean ascensor,
                                                  @RequestParam(required = false) Boolean terraza,
                                                  @RequestParam(required = false) Boolean garaje,
                                                  @RequestParam(required = false) Boolean disponible
                                                  ){
        ParametrosDto dto = new ParametrosDto(
                ciudad,
                provincia,
                precioMin,
                precioMax,
                metrosMin,
                metrosMax,
                habMin,
                banosMin,
                tipo,
                estado,
                ascensor,
                terraza,
                garaje,
                disponible
        );
        return viviendaService.devolverFiltrado(dto,pageable).map(ViviendaResponse::of);



    }

    @PostMapping
    public ResponseEntity<ViviendaResponse> create(@Valid @RequestBody ViviendaCreateRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(ViviendaResponse.of(viviendaService.create(request)));
    }


}
