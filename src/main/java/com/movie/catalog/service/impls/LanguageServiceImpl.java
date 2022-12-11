package com.movie.catalog.service.impls;

import com.movie.catalog.models.Language;
import com.movie.catalog.repositories.LanguageRepository;
import com.movie.catalog.service.LanguageService;
import com.movie.catalog.service.dtos.LanguageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    @Override
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public Language save(LanguageDTO dto) {
        return languageRepository.save(dto.toEntity());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    @Override
    public Language findById(Long id) {
        return languageRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void delete(Long id) {
        languageRepository.deleteById(id);
    }
}
