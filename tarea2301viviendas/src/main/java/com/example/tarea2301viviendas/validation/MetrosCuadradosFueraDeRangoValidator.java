package com.example.tarea2301viviendas.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MetrosCuadradosFueraDeRangoValidator implements ConstraintValidator<MetrosCuadradosFueraDeRango,Integer> {

    private int metrosCuadradosMax;
    @Override
    public void initialize(MetrosCuadradosFueraDeRango constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        metrosCuadradosMax = constraintAnnotation.metrosCuadradosMax();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return integer != null && integer<metrosCuadradosMax;
    }


}
