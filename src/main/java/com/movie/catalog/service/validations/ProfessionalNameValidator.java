package com.movie.catalog.service.validations;

import com.movie.catalog.repositories.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.util.Objects.isNull;

public class ProfessionalNameValidator implements ConstraintValidator<ValidProfessionalName, String> {

    @Autowired
    private ProfessionalRepository professionalRepository;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return isNull(name) || professionalRepository.findByName(name).isPresent();
    }

}
