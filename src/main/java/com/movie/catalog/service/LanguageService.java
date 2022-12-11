package com.movie.catalog.service;

import com.movie.catalog.models.Language;
import com.movie.catalog.service.dtos.LanguageDTO;

import java.util.List;

public interface LanguageService {
    Language save(LanguageDTO dto);

    List<Language> findAll();

    Language findById(Long id);

    void delete(Long id);
}
