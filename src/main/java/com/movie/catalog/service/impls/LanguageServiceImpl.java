package com.movie.catalog.service.impls;

import com.movie.catalog.models.Language;
import com.movie.catalog.repositories.LanguageRepository;
import com.movie.catalog.service.LanguageService;
import com.movie.catalog.service.dtos.LanguageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    @Override
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public Language save(LanguageDTO dto) {
        return languageRepository.save(dto.toEntity());
    }
}
