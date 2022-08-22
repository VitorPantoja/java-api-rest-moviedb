package com.movie.catalog.service.impls;

import com.movie.catalog.models.Movie;
import com.movie.catalog.repositories.MovieRepository;
import com.movie.catalog.service.MovieService;
import com.movie.catalog.service.dtos.CreateUpdateMovieDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public Movie save(CreateUpdateMovieDTO movie) {
        return movieRepository.saveAndFlush(movie.toEntity());
    }
}
