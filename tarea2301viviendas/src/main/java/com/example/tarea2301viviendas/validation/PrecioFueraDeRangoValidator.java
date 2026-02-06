package com.example.tarea2301viviendas.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrecioFueraDeRangoValidator implements ConstraintValidator<PrecioFueraDeRango,Integer> {

    private int precioMax;

    @Override
    public void initialize(PrecioFueraDeRango constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        precioMax = constraintAnnotation.precioMax();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return integer!=null && integer<precioMax;
    }

}
