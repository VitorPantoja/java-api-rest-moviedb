package com.movie.catalog.service;

import com.movie.catalog.models.GenreLanguage;
import com.movie.catalog.service.dtos.CreateUpdateGenreLanguageDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GenreLanguageService {

    GenreLanguage save(CreateUpdateGenreLanguageDTO dto);

    List<GenreLanguage> findByGenre_Id(Long id);

}
