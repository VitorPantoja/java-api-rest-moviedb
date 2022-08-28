package com.movie.catalog.service.impls;

import com.movie.catalog.models.GenreLanguage;
import com.movie.catalog.repositories.GenreLanguageRepository;
import com.movie.catalog.service.GenreLanguageService;
import com.movie.catalog.service.dtos.CreateUpdateGenreLanguageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GenreLanguageServiceImpl implements GenreLanguageService {

    private final GenreLanguageRepository genreLanguageRepository;

    @Override
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public GenreLanguage save(CreateUpdateGenreLanguageDTO dto) {
        return genreLanguageRepository.saveAndFlush(dto.toEntity());
    }
}
