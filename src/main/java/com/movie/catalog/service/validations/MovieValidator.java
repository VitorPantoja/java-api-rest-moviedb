package com.movie.catalog.service.validations;

import com.movie.catalog.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.util.Objects.isNull;

public class MovieValidator implements ConstraintValidator<ValidMovie, Long> {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return isNull(id) || movieRepository.findById(id).isPresent();
    }

}
