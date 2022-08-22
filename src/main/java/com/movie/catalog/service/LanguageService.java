package com.movie.catalog.service;

import com.movie.catalog.models.Language;
import com.movie.catalog.service.dtos.LanguageDTO;

public interface LanguageService {
    Language save(LanguageDTO dto);
}
