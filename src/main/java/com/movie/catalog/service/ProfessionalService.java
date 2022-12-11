package com.movie.catalog.service;

import com.movie.catalog.models.Professional;

import java.util.List;

public interface ProfessionalService {

    Professional save(String professional);

    Professional findById(Long id);

    List<Professional> findAll();

    void delete(Long id);
}
