package com.example.tarea2301viviendas.filter;

import com.example.tarea2301viviendas.model.EstadoVivienda;
import com.example.tarea2301viviendas.model.TipoVivienda;
import com.example.tarea2301viviendas.model.Vivienda;
import org.springframework.data.jpa.domain.PredicateSpecification;

public  interface ViviendaSpec {
    public static PredicateSpecification<Vivienda> filtrarPorCiudad(String ciudad){
        return ((from, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(from.get("ciudad")),"%" +ciudad.toLowerCase() + "%" )
                );
    }

    public static PredicateSpecification<Vivienda> filtrarPorProvincia(String provincia){
        return ((from, criteriaBuilder) ->
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

    public static PredicateSpecification<Vivienda> filtrarPorNumHabitaciones(int habMin){
        return (from, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(from.get("habitaciones"),habMin);
    }

    public static PredicateSpecification<Vivienda> filtrarPorNumBanios(int banosMin){
        return (from, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(from.get("banos"),banosMin);
    }
    public static PredicateSpecification<Vivienda> filtrarPorTipo(TipoVivienda tipo){
        return ((from, criteriaBuilder) ->
                criteriaBuilder.equal(from.get("tipoVivienda"),tipo));
    }

    public static PredicateSpecification<Vivienda> filtrarPorEstado(EstadoVivienda estado){
        return ((from, criteriaBuilder) ->
                criteriaBuilder.equal(from.get("estado"),estado));
    }

    public static  PredicateSpecification<Vivienda> filtrarPorAscensor(){
        return (from, criteriaBuilder) ->
                criteriaBuilder.isTrue(from.get("ascensor"));
    }

    public static  PredicateSpecification<Vivienda> filtrarPorTerraza(){
        return (from, criteriaBuilder) ->
                criteriaBuilder.isTrue(from.get("terraza"));
    }

    public static  PredicateSpecification<Vivienda> filtrarPorGaraje(){
        return (from, criteriaBuilder) ->
                criteriaBuilder.isTrue(from.get("garaje"));
    }

    public static  PredicateSpecification<Vivienda> filtrarPorDisponibilidad(boolean disponible){
        return (from, criteriaBuilder) ->{
                return criteriaBuilder.isTrue(from.get("disponible"));
        };
    }




}
