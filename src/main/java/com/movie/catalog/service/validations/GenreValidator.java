package com.movie.catalog.service.validations;

import com.movie.catalog.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.util.Objects.isNull;

public class GenreValidator implements ConstraintValidator<ValidGenre, Long> {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return isNull(id) || genreRepository.findById(id).isPresent();
    }

}
