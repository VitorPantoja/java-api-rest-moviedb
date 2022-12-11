package com.movie.catalog.service.validations;

import com.movie.catalog.repositories.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.util.Objects.isNull;

public class ProfessionalValidator implements ConstraintValidator<ValidProfessional, Long> {

    @Autowired
    private ProfessionalRepository professionalRepository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return isNull(id) || professionalRepository.findById(id).isPresent();
    }

}
