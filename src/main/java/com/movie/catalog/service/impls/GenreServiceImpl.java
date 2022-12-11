package com.movie.catalog.service.impls;

import com.movie.catalog.models.Genre;
import com.movie.catalog.repositories.GenreRepository;
import com.movie.catalog.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public Genre save(String genreName) {
        return genreRepository.saveAndFlush(Genre.builder()
                .setName(genreName)
                .build());
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre findById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void delete(Long id) {
        genreRepository.deleteById(id);
    }
}
