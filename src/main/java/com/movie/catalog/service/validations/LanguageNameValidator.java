package com.movie.catalog.service.validations;

import com.movie.catalog.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.util.Objects.isNull;

public class LanguageNameValidator implements ConstraintValidator<ValidLanguage, String> {

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return isNull(name) || languageRepository.findByName(name).isPresent();
    }
}
