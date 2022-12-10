package com.movie.catalog.service.validations;

import com.movie.catalog.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.util.Objects.isNull;

public class LanguageValidator implements ConstraintValidator<ValidLanguage, Long> {

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return isNull(id) || languageRepository.findById(id).isPresent();
    }

}
