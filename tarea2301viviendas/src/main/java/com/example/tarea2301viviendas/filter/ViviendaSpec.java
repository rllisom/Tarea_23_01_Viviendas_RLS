package com.example.tarea2301viviendas.filter;

import com.example.tarea2301viviendas.model.EstadoVivienda;
import com.example.tarea2301viviendas.model.TipoVivienda;
import com.example.tarea2301viviendas.model.Vivienda;
import org.springframework.data.jpa.domain.PredicateSpecification;

public  interface ViviendaSpec {
    public static PredicateSpecification<Vivienda> filtrarPorCiudad(String ciudad){
        return ((from, criteriaBuilder) ->
                ciudad == null? criteriaBuilder.and() :
                criteriaBuilder.like(criteriaBuilder.lower(from.get("ciudad")),"%" +ciudad.toLowerCase() + "%" )
                );
    }

    public static PredicateSpecification<Vivienda> filtrarPorProvincia(String provincia){
        return ((from, criteriaBuilder) ->
                provincia == null? criteriaBuilder.and() :
                criteriaBuilder.equal(criteriaBuilder.lower(from.get("provincia")),provincia.toLowerCase()));
    }

    public static PredicateSpecification<Vivienda> filtrarPorPrecio(Double precioMin, Double precioMax){
        return (from, criteriaBuilder) -> {

           Double precio_min = (precioMin == null) ? 0.0 : precioMin;
           Double  precio_max = (precioMax == null) ? Double.POSITIVE_INFINITY : precioMax;

            return criteriaBuilder.between(from.get("precio"),precio_min,precio_max);
        };
    }

    public static PredicateSpecification<Vivienda> filtrarPorMetros(Double metrosMin, Double metrosMax){
        return (from, criteriaBuilder) -> {
            Double metros_min = (metrosMin==null)? 0.0 : metrosMin;
            Double metros_max = (metrosMax == null) ? Double.POSITIVE_INFINITY : metrosMax;
            return criteriaBuilder.between(from.get("metrosCuadrados"),metros_min,metros_max);
        };
    }

    public static PredicateSpecification<Vivienda> filtrarPorNumHabitaciones(Integer habMin){
        return (from, criteriaBuilder) ->
                habMin == null? criteriaBuilder.and() :
                criteriaBuilder.greaterThanOrEqualTo(from.get("habitaciones"),habMin);
    }

    public static PredicateSpecification<Vivienda> filtrarPorNumBanios(Integer banosMin){
        return (from, criteriaBuilder) ->
                banosMin == null? criteriaBuilder.and() :
                criteriaBuilder.greaterThanOrEqualTo(from.get("banos"),banosMin);
    }
    public static PredicateSpecification<Vivienda> filtrarPorTipo(TipoVivienda tipo){
        return ((from, criteriaBuilder) ->
                tipo == null? criteriaBuilder.and() :
                criteriaBuilder.equal(from.get("tipoVivienda"),tipo));
    }

    public static PredicateSpecification<Vivienda> filtrarPorEstado(EstadoVivienda estado){
        return ((from, criteriaBuilder) ->
                estado == null ? criteriaBuilder.and() :
                criteriaBuilder.equal(from.get("estado"),estado));
    }

    public static  PredicateSpecification<Vivienda> filtrarPorAscensor(Boolean ascensor){
        return (from, criteriaBuilder) ->
                ascensor == null? criteriaBuilder.and():
                criteriaBuilder.equal(from.get("ascensor"),ascensor);
    }

    public static  PredicateSpecification<Vivienda> filtrarPorTerraza(Boolean terraza){
        return (from, criteriaBuilder) ->
                terraza == null ? criteriaBuilder.and() :
                criteriaBuilder.equal(from.get("terraza"),terraza);
    }

    public static  PredicateSpecification<Vivienda> filtrarPorGaraje(Boolean garaje){
        return (from, criteriaBuilder) ->
                garaje == null ? criteriaBuilder.and() :
                criteriaBuilder.equal(from.get("garaje"),garaje);
    }

    public static  PredicateSpecification<Vivienda> filtrarPorDisponibilidad(Boolean disponible){
        return (from, criteriaBuilder) ->
                disponible == null ? criteriaBuilder.and() :
                criteriaBuilder.equal(from.get("disponible"),disponible);

    }




}
