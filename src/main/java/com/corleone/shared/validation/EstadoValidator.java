package com.corleone.shared.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class EstadoValidator implements ConstraintValidator<EstadoValido, String> {

    private static final Set<String> UFS = Set.of(
            "AC", "AL", "AP", "AM", "BA",
            "CE", "DF", "ES", "GO", "MA",
            "MT", "MS", "MG", "PA", "PB",
            "PR", "PE", "PI", "RJ", "RN",
            "RS", "RO", "RR", "SC", "SP",
            "SE", "TO"
    );

    @Override
    public boolean isValid(
            String value,
            ConstraintValidatorContext context
    ) {

        if (value == null || value.isBlank()) {
            return true;
        }

        return UFS.contains(
                value.trim().toUpperCase()
        );
    }
}