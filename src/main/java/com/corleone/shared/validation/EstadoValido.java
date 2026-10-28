package com.corleone.shared.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EstadoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EstadoValido {

    String message() default "UF inválida";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}