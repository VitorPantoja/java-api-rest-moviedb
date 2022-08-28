package com.movie.catalog.service;

import com.movie.catalog.models.GenreLanguage;
import com.movie.catalog.service.dtos.CreateUpdateGenreLanguageDTO;

public interface GenreLanguageService {

    GenreLanguage save(CreateUpdateGenreLanguageDTO dto);

}
