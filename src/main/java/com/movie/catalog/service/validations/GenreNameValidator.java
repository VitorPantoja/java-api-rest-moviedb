package com.movie.catalog.service.validations;

import com.movie.catalog.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.util.Objects.isNull;

public class GenreNameValidator implements ConstraintValidator<ValidGenreName, String> {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return isNull(name) || genreRepository.findByName(name).isPresent();
    }
}
