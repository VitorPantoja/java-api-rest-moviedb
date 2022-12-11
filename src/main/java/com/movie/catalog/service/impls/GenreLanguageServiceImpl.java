package com.movie.catalog.service.impls;

import com.movie.catalog.models.GenreLanguage;
import com.movie.catalog.repositories.GenreLanguageRepository;
import com.movie.catalog.service.GenreLanguageService;
import com.movie.catalog.service.dtos.CreateUpdateGenreLanguageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreLanguageServiceImpl implements GenreLanguageService {

    private final GenreLanguageRepository genreLanguageRepository;

    @Override
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public GenreLanguage save(CreateUpdateGenreLanguageDTO dto) {
        return genreLanguageRepository.saveAndFlush(dto.toEntity());
    }

    @Override
    public List<GenreLanguage> findByGenre_Id(Long id) {
        return genreLanguageRepository.findByGenre_Id(id);
    }
}
