package com.example.tarea2301viviendas.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PrecioFueraDeRangoValidator.class)
@Documented
public @interface PrecioFueraDeRango {

    String message () default "precio fuera de rango";

    Class<?>[] groups() default {};

    Class<? extends Payload> [] payload() default {};

    int precioMax();
}
